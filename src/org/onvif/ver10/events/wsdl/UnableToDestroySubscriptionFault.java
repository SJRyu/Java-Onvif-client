
package org.onvif.ver10.events.wsdl;

import javax.xml.ws.WebFault;
import org.oasis_open.docs.wsn.b_2.UnableToDestroySubscriptionFaultType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UnableToDestroySubscriptionFault", targetNamespace = "http://docs.oasis-open.org/wsn/b-2")
public class UnableToDestroySubscriptionFault
    extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6330009132009776378L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UnableToDestroySubscriptionFaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public UnableToDestroySubscriptionFault(String message, UnableToDestroySubscriptionFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public UnableToDestroySubscriptionFault(String message, UnableToDestroySubscriptionFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.oasis_open.docs.wsn.b_2.UnableToDestroySubscriptionFaultType
     */
    public UnableToDestroySubscriptionFaultType getFaultInfo() {
        return faultInfo;
    }

}
