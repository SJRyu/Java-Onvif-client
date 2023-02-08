
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
 *         &lt;element name="SerialPortOptions" type="{http://www.onvif.org/ver10/deviceIO/wsdl}SerialPortConfigurationOptions"/>
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
    "serialPortOptions"
})
@XmlRootElement(name = "GetSerialPortConfigurationOptionsResponse")
public class GetSerialPortConfigurationOptionsResponse {

    @XmlElement(name = "SerialPortOptions", required = true)
    protected SerialPortConfigurationOptions serialPortOptions;

    /**
     * Gets the value of the serialPortOptions property.
     * 
     * @return
     *     possible object is
     *     {@link SerialPortConfigurationOptions }
     *     
     */
    public SerialPortConfigurationOptions getSerialPortOptions() {
        return serialPortOptions;
    }

    /**
     * Sets the value of the serialPortOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SerialPortConfigurationOptions }
     *     
     */
    public void setSerialPortOptions(SerialPortConfigurationOptions value) {
        this.serialPortOptions = value;
    }

}
