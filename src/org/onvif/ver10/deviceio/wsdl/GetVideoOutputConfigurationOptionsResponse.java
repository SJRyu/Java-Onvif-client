
package org.onvif.ver10.deviceio.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.VideoOutputConfigurationOptions;
import org.w3c.dom.Element;


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
 *         &lt;element name="VideoOutputConfigurationOptions" type="{http://www.onvif.org/ver10/schema}VideoOutputConfigurationOptions"/>
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
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
    "videoOutputConfigurationOptions",
    "any"
})
@XmlRootElement(name = "GetVideoOutputConfigurationOptionsResponse")
public class GetVideoOutputConfigurationOptionsResponse {

    @XmlElement(name = "VideoOutputConfigurationOptions", required = true)
    protected VideoOutputConfigurationOptions videoOutputConfigurationOptions;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the videoOutputConfigurationOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VideoOutputConfigurationOptions }
     *     
     */
    public VideoOutputConfigurationOptions getVideoOutputConfigurationOptions() {
        return videoOutputConfigurationOptions;
    }

    /**
     * Sets the value of the videoOutputConfigurationOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoOutputConfigurationOptions }
     *     
     */
    public void setVideoOutputConfigurationOptions(VideoOutputConfigurationOptions value) {
        this.videoOutputConfigurationOptions = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
