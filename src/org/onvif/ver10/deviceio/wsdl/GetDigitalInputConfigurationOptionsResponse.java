
package org.onvif.ver10.deviceio.wsdl;

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
 *         &lt;element name="DigitalInputOptions" type="{http://www.onvif.org/ver10/deviceIO/wsdl}DigitalInputConfigurationOptions"/>
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
    "digitalInputOptions"
})
@XmlRootElement(name = "GetDigitalInputConfigurationOptionsResponse")
public class GetDigitalInputConfigurationOptionsResponse {

    @XmlElement(name = "DigitalInputOptions", required = true)
    protected DigitalInputConfigurationOptions digitalInputOptions;

    /**
     * Gets the value of the digitalInputOptions property.
     * 
     * @return
     *     possible object is
     *     {@link DigitalInputConfigurationOptions }
     *     
     */
    public DigitalInputConfigurationOptions getDigitalInputOptions() {
        return digitalInputOptions;
    }

    /**
     * Sets the value of the digitalInputOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DigitalInputConfigurationOptions }
     *     
     */
    public void setDigitalInputOptions(DigitalInputConfigurationOptions value) {
        this.digitalInputOptions = value;
    }

}
