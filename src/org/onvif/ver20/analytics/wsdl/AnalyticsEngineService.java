
package org.onvif.ver20.analytics.wsdl;

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
@WebServiceClient(name = "AnalyticsEngineService", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", wsdlLocation = "classpath:wsdl/analyticsProxy.wsdl")
public class AnalyticsEngineService
    extends Service
{

    private final static URL ANALYTICSENGINESERVICE_WSDL_LOCATION;
    private final static WebServiceException ANALYTICSENGINESERVICE_EXCEPTION;
    private final static QName ANALYTICSENGINESERVICE_QNAME = new QName("http://www.onvif.org/ver20/analytics/wsdl", "AnalyticsEngineService");

    static {
        ANALYTICSENGINESERVICE_WSDL_LOCATION = org.onvif.ver20.analytics.wsdl.AnalyticsEngineService.class.getResource("classpath:wsdl/analyticsProxy.wsdl");
        WebServiceException e = null;
        if (ANALYTICSENGINESERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'classpath:wsdl/analyticsProxy.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        ANALYTICSENGINESERVICE_EXCEPTION = e;
    }

    public AnalyticsEngineService() {
        super(__getWsdlLocation(), ANALYTICSENGINESERVICE_QNAME);
    }

    public AnalyticsEngineService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ANALYTICSENGINESERVICE_QNAME, features);
    }

    public AnalyticsEngineService(URL wsdlLocation) {
        super(wsdlLocation, ANALYTICSENGINESERVICE_QNAME);
    }

    public AnalyticsEngineService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ANALYTICSENGINESERVICE_QNAME, features);
    }

    public AnalyticsEngineService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AnalyticsEngineService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AnalyticsEnginePort
     */
    @WebEndpoint(name = "AnalyticsEngineServicePort")
    public AnalyticsEnginePort getAnalyticsEngineServicePort() {
        return super.getPort(new QName("http://www.onvif.org/ver20/analytics/wsdl", "AnalyticsEngineServicePort"), AnalyticsEnginePort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AnalyticsEnginePort
     */
    @WebEndpoint(name = "AnalyticsEngineServicePort")
    public AnalyticsEnginePort getAnalyticsEngineServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.onvif.org/ver20/analytics/wsdl", "AnalyticsEngineServicePort"), AnalyticsEnginePort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ANALYTICSENGINESERVICE_EXCEPTION!= null) {
            throw ANALYTICSENGINESERVICE_EXCEPTION;
        }
        return ANALYTICSENGINESERVICE_WSDL_LOCATION;
    }

}
