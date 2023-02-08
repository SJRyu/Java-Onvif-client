
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for VideoEncoder2Configuration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoEncoder2Configuration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onvif.org/ver10/schema}ConfigurationEntity">
 *       &lt;sequence>
 *         &lt;element name="Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Resolution" type="{http://www.onvif.org/ver10/schema}VideoResolution2"/>
 *         &lt;element name="RateControl" type="{http://www.onvif.org/ver10/schema}VideoRateControl2" minOccurs="0"/>
 *         &lt;element name="Multicast" type="{http://www.onvif.org/ver10/schema}MulticastConfiguration" minOccurs="0"/>
 *         &lt;element name="Quality" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GovLength" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Profile" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GuaranteedFrameRate" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoEncoder2Configuration", propOrder = {
    "encoding",
    "resolution",
    "rateControl",
    "multicast",
    "quality",
    "any"
})
public class VideoEncoder2Configuration
    extends ConfigurationEntity
{

    @XmlElement(name = "Encoding", required = true)
    protected String encoding;
    @XmlElement(name = "Resolution", required = true)
    protected VideoResolution2 resolution;
    @XmlElement(name = "RateControl")
    protected VideoRateControl2 rateControl;
    @XmlElement(name = "Multicast")
    protected MulticastConfiguration multicast;
    @XmlElement(name = "Quality")
    protected float quality;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "GovLength")
    protected Integer govLength;
    @XmlAttribute(name = "Profile")
    protected String profile;
    @XmlAttribute(name = "GuaranteedFrameRate")
    protected Boolean guaranteedFrameRate;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link VideoResolution2 }
     *     
     */
    public VideoResolution2 getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoResolution2 }
     *     
     */
    public void setResolution(VideoResolution2 value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the rateControl property.
     * 
     * @return
     *     possible object is
     *     {@link VideoRateControl2 }
     *     
     */
    public VideoRateControl2 getRateControl() {
        return rateControl;
    }

    /**
     * Sets the value of the rateControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoRateControl2 }
     *     
     */
    public void setRateControl(VideoRateControl2 value) {
        this.rateControl = value;
    }

    /**
     * Gets the value of the multicast property.
     * 
     * @return
     *     possible object is
     *     {@link MulticastConfiguration }
     *     
     */
    public MulticastConfiguration getMulticast() {
        return multicast;
    }

    /**
     * Sets the value of the multicast property.
     * 
     * @param value
     *     allowed object is
     *     {@link MulticastConfiguration }
     *     
     */
    public void setMulticast(MulticastConfiguration value) {
        this.multicast = value;
    }

    /**
     * Gets the value of the quality property.
     * 
     */
    public float getQuality() {
        return quality;
    }

    /**
     * Sets the value of the quality property.
     * 
     */
    public void setQuality(float value) {
        this.quality = value;
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

    /**
     * Gets the value of the govLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGovLength() {
        return govLength;
    }

    /**
     * Sets the value of the govLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGovLength(Integer value) {
        this.govLength = value;
    }

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfile(String value) {
        this.profile = value;
    }

    /**
     * Gets the value of the guaranteedFrameRate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuaranteedFrameRate() {
        return guaranteedFrameRate;
    }

    /**
     * Sets the value of the guaranteedFrameRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuaranteedFrameRate(Boolean value) {
        this.guaranteedFrameRate = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
