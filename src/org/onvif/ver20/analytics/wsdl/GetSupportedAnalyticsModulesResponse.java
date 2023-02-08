
package org.onvif.ver20.analytics.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.SupportedAnalyticsModules;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupportedAnalyticsModules" type="{http://www.onvif.org/ver10/schema}SupportedAnalyticsModules"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "supportedAnalyticsModules"
})
@XmlRootElement(name = "GetSupportedAnalyticsModulesResponse")
public class GetSupportedAnalyticsModulesResponse {

    @XmlElement(name = "SupportedAnalyticsModules", required = true)
    protected SupportedAnalyticsModules supportedAnalyticsModules;

    /**
     * Gets the value of the supportedAnalyticsModules property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedAnalyticsModules }
     *     
     */
    public SupportedAnalyticsModules getSupportedAnalyticsModules() {
        return supportedAnalyticsModules;
    }

    /**
     * Sets the value of the supportedAnalyticsModules property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedAnalyticsModules }
     *     
     */
    public void setSupportedAnalyticsModules(SupportedAnalyticsModules value) {
        this.supportedAnalyticsModules = value;
    }

}
