package sjryu.onvif.client;

import org.onvif.ver10.events.wsdl.ObjectFactory;
import org.onvif.ver10.events.wsdl.PullMessages;
import org.onvif.ver10.events.wsdl.PullMessagesResponse;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMResult;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.W3CDomHandler;
import javax.xml.datatype.DatatypeFactory;

import org.oasis_open.docs.wsn.b_2.FilterType;
import org.oasis_open.docs.wsn.b_2.Renew;
import org.oasis_open.docs.wsn.b_2.RenewResponse;
import org.oasis_open.docs.wsn.b_2.TopicExpressionType;
import org.oasis_open.docs.wsn.b_2.Unsubscribe;
import org.onvif.ver10.events.wsdl.Capabilities;
import org.onvif.ver10.events.wsdl.CreatePullPointSubscription;
import org.onvif.ver10.events.wsdl.CreatePullPointSubscriptionResponse;
import org.onvif.ver10.events.wsdl.GetEventProperties;
import org.onvif.ver10.events.wsdl.GetEventPropertiesResponse;
import org.onvif.ver10.events.wsdl.GetServiceCapabilities;
import org.onvif.ver10.events.wsdl.GetServiceCapabilitiesResponse;

public class EventProxy extends OnvifProxy
{
	private final static String SUBSCRIBE_TIME = "PT600S";
	private final static String PULLMESSAGE_TIMEOUT = "PT1M";
	private final static String SubscribtionNamespace = "http://docs.oasis-open.org/wsn/bw-2";

	ObjectFactory factory_;
	
	String pullpoint_;
	Dispatch<SOAPMessage> pullpointDispatch_;

	protected EventProxy(String xAddr, SoapClientSecurity security)
	{
		super("http://www.onvif.org/ver10/events/wsdl", xAddr, security);
		factory_ = new ObjectFactory();
		
		pullpoint_ = null;
		pullpointDispatch_ = null;
	}
	
	public Capabilities GetServiceCapabilities() throws Exception
	{
		GetServiceCapabilities request = factory_.createGetServiceCapabilities();
		
		GetServiceCapabilitiesResponse response = request(request, GetServiceCapabilitiesResponse.class, true);
		
		return response.getCapabilities();
	}
	
	public boolean CreatePullPointSubscription(String topic) throws Exception
	{
		CreatePullPointSubscription request = factory_.createCreatePullPointSubscription();
		CreatePullPointSubscriptionResponse response = null;

		request.setInitialTerminationTime(
				factory_.createCreatePullPointSubscriptionInitialTerminationTime(SUBSCRIBE_TIME));

		if (topic != null)
		{
			TopicExpressionType topicExpression = new TopicExpressionType();
			topicExpression.setDialect("http://www.onvif.org/ver10/tev/topicExpression/ConcreteSet");
			
			// value of element could be written directly by String
			topicExpression.getContent().add(topic);
			
			QName qName = new QName("http://docs.oasis-open.org/wsn/b-2", "TopicExpression");
			JAXBElement<TopicExpressionType> jaxbelm = 
					new JAXBElement<TopicExpressionType>(qName, TopicExpressionType.class, topicExpression);
			
			FilterType filter = new FilterType();
			filter.getAny().add(jaxbelm);
			
			request.setFilter(filter);
		}
		
		response = request(request, CreatePullPointSubscriptionResponse.class, true);
		if (response == null)
		{
			return false;
		}

		W3CEndpointReference epr = response.getSubscriptionReference();
		DOMResult dr = new DOMResult();
		epr.writeTo(dr);

		W3CDomHandler dh = new W3CDomHandler();
		Element el = dh.getElement(dr);

		// expect only one
		NodeList nodes = el.getElementsByTagName("Address");
		// a value is a node like elem and attr
		Node addressValue = nodes.item(0).getFirstChild();
		// get value from value-node
		pullpoint_ = addressValue.getNodeValue();
		
		pullpointDispatch_ = SoapClient.createDispatch(namespace_, pullpoint_);
		
		return true;
	}
	
	public String getPullpoint()
	{
		return pullpoint_;
	}

	public GetEventPropertiesResponse GetEventProperties() throws Exception
	{
		GetEventProperties request = factory_.createGetEventProperties();
		GetEventPropertiesResponse response = null;

		response = request(request, GetEventPropertiesResponse.class, true);

		return response;
	}
	
	@Deprecated
	public PullMessagesResponse PullMessages() throws Exception
	{
		PullMessages request = factory_.createPullMessages();
		PullMessagesResponse response = null;

		DatatypeFactory dfactory = DatatypeFactory.newInstance();
		Duration duration = dfactory.newDuration(PULLMESSAGE_TIMEOUT);

		request.setTimeout(duration);
		request.setMessageLimit(2048);

		security_.updateEncryption();
		   
		response = SoapClient.request(namespace_, pullpoint_, request, PullMessagesResponse.class,
				61000, security_);

		return response;
	}
	
	public Response<SOAPMessage> PullMessagesAsync() throws Exception
	{
		PullMessages request = factory_.createPullMessages();
		Response<SOAPMessage> response = null;

		DatatypeFactory dfactory = DatatypeFactory.newInstance();
		Duration duration = dfactory.newDuration(PULLMESSAGE_TIMEOUT);

		request.setTimeout(duration);
		request.setMessageLimit(2048); // This determines the number of separating response in   

		security_.updateEncryption();
		response = SoapClient.requestAsync(pullpointDispatch_, request, security_);

		return response;
	}

	public PullMessagesResponse getPullMessagesResponseAsync(Response<SOAPMessage> response) throws Exception
	{
		PullMessagesResponse ret = null;

		ret = SoapClient.getAsyncResponse(response, PullMessagesResponse.class);

		return ret;
	}

	public RenewResponse Renew() throws Exception
	{
		Renew request = new Renew();
		RenewResponse response = null;

		request.setTerminationTime(PULLMESSAGE_TIMEOUT);

		security_.updateEncryption();
		response = SoapClient.request(SubscribtionNamespace, pullpoint_, request, RenewResponse.class, security_);

		return response;
	}
	
	public void Unsubscribe() throws Exception
	{
		pullpointDispatch_ = null;
		
		Unsubscribe request = new Unsubscribe();

		security_.updateEncryption();
		SoapClient.request(SubscribtionNamespace, pullpoint_, request, RenewResponse.class, security_);
	}
	
}
