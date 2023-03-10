
package org.onvif.ver20.imaging.wsdl;

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
 *         &lt;element name="Preset" type="{http://www.onvif.org/ver20/imaging/wsdl}ImagingPreset" minOccurs="0"/>
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
    "preset"
})
@XmlRootElement(name = "GetCurrentPresetResponse")
public class GetCurrentPresetResponse {

    @XmlElement(name = "Preset")
    protected ImagingPreset preset;

    /**
     * Gets the value of the preset property.
     * 
     * @return
     *     possible object is
     *     {@link ImagingPreset }
     *     
     */
    public ImagingPreset getPreset() {
        return preset;
    }

    /**
     * Sets the value of the preset property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingPreset }
     *     
     */
    public void setPreset(ImagingPreset value) {
        this.preset = value;
    }

}
