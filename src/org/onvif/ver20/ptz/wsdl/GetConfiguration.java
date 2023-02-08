
package org.onvif.ver20.ptz.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="PTZConfigurationToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken"/>
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
    "ptzConfigurationToken"
})
@XmlRootElement(name = "GetConfiguration")
public class GetConfiguration {

    @XmlElement(name = "PTZConfigurationToken", required = true)
    protected String ptzConfigurationToken;

    /**
     * Gets the value of the ptzConfigurationToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTZConfigurationToken() {
        return ptzConfigurationToken;
    }

    /**
     * Sets the value of the ptzConfigurationToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTZConfigurationToken(String value) {
        this.ptzConfigurationToken = value;
    }

}
