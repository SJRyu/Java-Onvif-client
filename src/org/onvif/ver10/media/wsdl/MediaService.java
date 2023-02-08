
package org.onvif.ver10.media.wsdl;

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
@WebServiceClient(name = "MediaService", targetNamespace = "http://www.onvif.org/ver10/media/wsdl", wsdlLocation = "classpath:wsdl/mediaProxy.wsdl")
public class MediaService
    extends Service
{

    private final static URL MEDIASERVICE_WSDL_LOCATION;
    private final static WebServiceException MEDIASERVICE_EXCEPTION;
    private final static QName MEDIASERVICE_QNAME = new QName("http://www.onvif.org/ver10/media/wsdl", "MediaService");

    static {
        MEDIASERVICE_WSDL_LOCATION = org.onvif.ver10.media.wsdl.MediaService.class.getResource("classpath:wsdl/mediaProxy.wsdl");
        WebServiceException e = null;
        if (MEDIASERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'classpath:wsdl/mediaProxy.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        MEDIASERVICE_EXCEPTION = e;
    }

    public MediaService() {
        super(__getWsdlLocation(), MEDIASERVICE_QNAME);
    }

    public MediaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MEDIASERVICE_QNAME, features);
    }

    public MediaService(URL wsdlLocation) {
        super(wsdlLocation, MEDIASERVICE_QNAME);
    }

    public MediaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MEDIASERVICE_QNAME, features);
    }

    public MediaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MediaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Media
     */
    @WebEndpoint(name = "MediaServicePort")
    public Media getMediaServicePort() {
        return super.getPort(new QName("http://www.onvif.org/ver10/media/wsdl", "MediaServicePort"), Media.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Media
     */
    @WebEndpoint(name = "MediaServicePort")
    public Media getMediaServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.onvif.org/ver10/media/wsdl", "MediaServicePort"), Media.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MEDIASERVICE_EXCEPTION!= null) {
            throw MEDIASERVICE_EXCEPTION;
        }
        return MEDIASERVICE_WSDL_LOCATION;
    }

}
