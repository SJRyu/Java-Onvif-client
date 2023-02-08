
package org.onvif.ver10.events.wsdl;

import javax.xml.ws.WebFault;
import org.oasis_open.docs.wsn.b_2.SubscribeCreationFailedFaultType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "SubscribeCreationFailedFault", targetNamespace = "http://docs.oasis-open.org/wsn/b-2")
public class SubscribeCreationFailedFault
    extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5339466084497720491L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SubscribeCreationFailedFaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public SubscribeCreationFailedFault(String message, SubscribeCreationFailedFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public SubscribeCreationFailedFault(String message, SubscribeCreationFailedFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.oasis_open.docs.wsn.b_2.SubscribeCreationFailedFaultType
     */
    public SubscribeCreationFailedFaultType getFaultInfo() {
        return faultInfo;
    }

}
