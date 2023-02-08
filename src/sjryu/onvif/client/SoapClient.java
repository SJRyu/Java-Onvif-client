package sjryu.onvif.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import org.w3c.dom.Document;

import com.sun.xml.ws.developer.JAXWSProperties;

public class SoapClient
{
	final static boolean bDebug = false;

	protected static <T> T request(String namespace, String xAddr, Object requestBinding, Class<T> responseType,
			SoapClientSecurity security) throws Exception
	{
		return request(namespace, xAddr, requestBinding, responseType, 2000, security);
	}
	
	protected static <T> T request(String namespace, String xAddr, Object requestBinding, Class<T> responseType,
			int timeout,
			SoapClientSecurity security) throws Exception
	{
		QName serviceName = new QName(namespace, "OnvifService");
		QName portName = new QName(namespace, "OnvifPort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, xAddr);
		
		Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
		
		dispatch.getRequestContext().put(JAXWSProperties.CONNECT_TIMEOUT, timeout);
		dispatch.getRequestContext().put(JAXWSProperties.REQUEST_TIMEOUT, timeout);
		
		SOAPMessage request = createSoapMessage(requestBinding, security);
		if (bDebug)
		{
			System.out.print("Request SOAP Message (" + requestBinding.getClass().getSimpleName() + "): ");
			request.writeTo(System.out);
			System.out.println();
		}

		SOAPMessage response = dispatch.invoke(request);
		if (response.getSOAPPart().getEnvelope().getBody().getFault() != null)
		{
			String fault = response.getSOAPPart().getEnvelope().getBody().getFault().getFaultCode();
			if (fault.length() > 0)
			{
				throw new SOAPException("Bad Response:" + fault);
			}
		}

		return unmarshallMessage(response, responseType);
	}
	
	@Deprecated
	protected static <T> T request(String namespace, String xAddr, Object requestBinding, Class<T> responseType,
			String action, SoapClientSecurity security) throws Exception
	{
		QName serviceName = new QName(namespace, "OnvifService");
		QName portName = new QName(namespace, "OnvifPort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, xAddr);
		
		Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);

		dispatch.getRequestContext().put("javax.xml.ws.soap.http.soapaction.use", true);
		dispatch.getRequestContext().put("javax.xml.ws.soap.http.soapaction.uri", action);
		
		SOAPMessage request = createSoapMessage(requestBinding, security);
		if (bDebug)
		{
			System.out.print("Request SOAP Message (" + requestBinding.getClass().getSimpleName() + "): ");
			request.writeTo(System.out);
			System.out.println();
		}

		SOAPMessage response = dispatch.invoke(request);
		if (response.getSOAPPart().getEnvelope().getBody().getFault() != null)
		{
			String fault = response.getSOAPPart().getEnvelope().getBody().getFault().getFaultCode();
			if (fault.length() > 0)
			{
				throw new SOAPException("Bad Response:" + fault);
			}
		}

		return unmarshallMessage(response, responseType);
	}

	
	/**
	 * Purpose for reusing instances of dispatch
	 * @param namespace
	 * @param xAddr
	 * @return
	 * @throws Exception
	 */
	protected static Dispatch<SOAPMessage> createDispatch(String namespace, String xAddr) throws Exception
	{
		QName serviceName = new QName(namespace, "OnvifService");
		QName portName = new QName(namespace, "OnvifPort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, xAddr);

		/*
		 * if you set specific executor, you have to shutdown it manullay. 
		 */
		//ExecutorService dispatchpool = Executors.newSingleThreadExecutor();
		//service.setExecutor(dispatchpool);
		
		Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
		
		return dispatch;
	}
	
	protected static Response<SOAPMessage> requestAsync(Dispatch<SOAPMessage> dispatch, Object soapRequestElem,
			SoapClientSecurity security) throws Exception
	{
		SOAPMessage request = createSoapMessage(soapRequestElem, security);
		if (bDebug)
		{
			System.out.print("Request SOAP Message (" + soapRequestElem.getClass().getSimpleName() + "): ");
			request.writeTo(System.out);
			System.out.println();
		}

		Response<SOAPMessage> response = dispatch.invokeAsync(request);

		return response;
	}
	
	/**
	 * @param namespace
	 * @param xAddr
	 * @param soapRequestElem
	 * @param security
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	protected static Response<SOAPMessage> requestAsync(String namespace, String xAddr, Object soapRequestElem,
			SoapClientSecurity security) throws Exception
	{
		QName serviceName = new QName(namespace, "OnvifService");
		QName portName = new QName(namespace, "OnvifPort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, xAddr);

		Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
		
		SOAPMessage request = createSoapMessage(soapRequestElem, security);
		if (bDebug)
		{
			System.out.print("Request SOAP Message (" + soapRequestElem.getClass().getSimpleName() + "): ");
			request.writeTo(System.out);
			System.out.println();
		}

		Response<SOAPMessage> response = dispatch.invokeAsync(request);

		return response;
	}
	
	@Deprecated
	protected static Response<SOAPMessage> requestAsync(
			String namespace, String xAddr, Object soapRequestElem,
			String action,
			SoapClientSecurity security) throws Exception
	{
		QName serviceName = new QName(namespace, "OnvifService");
		QName portName = new QName(namespace, "OnvifPort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING, xAddr);

		Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
		
		dispatch.getRequestContext().put("javax.xml.ws.soap.http.soapaction.use", true);
		dispatch.getRequestContext().put("javax.xml.ws.soap.http.soapaction.uri", new String(action));
		
		SOAPMessage request = createSoapMessage(soapRequestElem, security);
		if (bDebug)
		{
			System.out.print("Request SOAP Message (" + soapRequestElem.getClass().getSimpleName() + "): ");
			request.writeTo(System.out);
			System.out.println();
		}

		Response<SOAPMessage> response = dispatch.invokeAsync(request);

		return response;
	}

	protected static <T> T getAsyncResponse(Response<SOAPMessage> response, Class<T> responseType) throws Exception
	{
		return unmarshallMessage(response.get(), responseType);
	}

	protected static SOAPMessage createSoapMessage(Object requestBinding, SoapClientSecurity security) throws Exception
	{
		MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = messageFactory.createMessage();

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Marshaller marshaller = JAXBContext.newInstance(requestBinding.getClass()).createMarshaller();
		marshaller.marshal(requestBinding, document);
		soapMessage.getSOAPBody().addDocument(document);

		if (security != null) AddSecurityToken(soapMessage, security);

		soapMessage.saveChanges();
		return soapMessage;
	}

	@SuppressWarnings("unchecked")
	protected static <T> T unmarshallMessage(SOAPMessage message, Class<T> ObjectType) throws Exception
	{
		Object instance = null;

		Unmarshaller unmarshaller = JAXBContext.newInstance(ObjectType).createUnmarshaller();

		instance = unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
		// UnmarshalException => it's a fault response

		return ((T)instance);
	}

	protected static void AddSecurityToken(SOAPMessage soapMessage, SoapClientSecurity security) throws Exception
	{
		String encrypedPassword = security.getEncryptedPasswd();

		SOAPPart sp = soapMessage.getSOAPPart();
		SOAPEnvelope se = sp.getEnvelope();
		SOAPHeader header = soapMessage.getSOAPHeader();
		se.addNamespaceDeclaration("wsse",
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		se.addNamespaceDeclaration("wsu",
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

		SOAPElement securityElem = header.addChildElement("Security", "wsse");
		// securityElem.setAttribute("SOAP-ENV:mustUnderstand", "1");

		SOAPElement usernameTokenElem = securityElem.addChildElement("UsernameToken", "wsse");

		SOAPElement usernameElem = usernameTokenElem.addChildElement("Username", "wsse");
		usernameElem.setTextContent(security.getUser());

		SOAPElement passwordElem = usernameTokenElem.addChildElement("Password", "wsse");
		passwordElem.setAttribute("Type",
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest");
		passwordElem.setTextContent(encrypedPassword);

		SOAPElement nonceElem = usernameTokenElem.addChildElement("Nonce", "wsse");
		nonceElem.setAttribute("EncodingType",
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
		nonceElem.setTextContent(security.getEncodedNonce());

		SOAPElement createdElem = usernameTokenElem.addChildElement("Created", "wsu");
		createdElem.setTextContent(security.getTimeStamp());
	}

}
