
package org.onvif.ver20.analytics.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.SupportedRules;


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
 *         &lt;element name="SupportedRules" type="{http://www.onvif.org/ver10/schema}SupportedRules"/>
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
    "supportedRules"
})
@XmlRootElement(name = "GetSupportedRulesResponse")
public class GetSupportedRulesResponse {

    @XmlElement(name = "SupportedRules", required = true)
    protected SupportedRules supportedRules;

    /**
     * Gets the value of the supportedRules property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedRules }
     *     
     */
    public SupportedRules getSupportedRules() {
        return supportedRules;
    }

    /**
     * Sets the value of the supportedRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedRules }
     *     
     */
    public void setSupportedRules(SupportedRules value) {
        this.supportedRules = value;
    }

}
