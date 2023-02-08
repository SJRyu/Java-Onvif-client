
package org.onvif.ver10.events.wsdl;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EventService", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", wsdlLocation = "classpath:wsdl/eventProxy.wsdl")
public class EventService
    extends Service
{

    private final static URL EVENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException EVENTSERVICE_EXCEPTION;
    private final static QName EVENTSERVICE_QNAME = new QName("http://www.onvif.org/ver10/events/wsdl", "EventService");

    static {
        EVENTSERVICE_WSDL_LOCATION = org.onvif.ver10.events.wsdl.EventService.class.getResource("classpath:wsdl/eventProxy.wsdl");
        WebServiceException e = null;
        if (EVENTSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'classpath:wsdl/eventProxy.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        EVENTSERVICE_EXCEPTION = e;
    }

    public EventService() {
        super(__getWsdlLocation(), EVENTSERVICE_QNAME);
    }

    public EventService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EVENTSERVICE_QNAME, features);
    }

    public EventService(URL wsdlLocation) {
        super(wsdlLocation, EVENTSERVICE_QNAME);
    }

    public EventService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EVENTSERVICE_QNAME, features);
    }

    public EventService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EventService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EventPortType
     */
    @WebEndpoint(name = "EventServicePort")
    public EventPortType getEventServicePort() {
        return super.getPort(new QName("http://www.onvif.org/ver10/events/wsdl", "EventServicePort"), EventPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EventPortType
     */
    @WebEndpoint(name = "EventServicePort")
    public EventPortType getEventServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.onvif.org/ver10/events/wsdl", "EventServicePort"), EventPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EVENTSERVICE_EXCEPTION!= null) {
            throw EVENTSERVICE_EXCEPTION;
        }
        return EVENTSERVICE_WSDL_LOCATION;
    }

}
