
package org.onvif.ver20.imaging.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImagingPresetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ImagingPresetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Custom"/>
 *     &lt;enumeration value="ClearWeather"/>
 *     &lt;enumeration value="Cloudy"/>
 *     &lt;enumeration value="Fog"/>
 *     &lt;enumeration value="Rain"/>
 *     &lt;enumeration value="Snowing"/>
 *     &lt;enumeration value="Snow"/>
 *     &lt;enumeration value="WDR"/>
 *     &lt;enumeration value="Shade"/>
 *     &lt;enumeration value="Night"/>
 *     &lt;enumeration value="Indoor"/>
 *     &lt;enumeration value="Fluorescent"/>
 *     &lt;enumeration value="Incandescent"/>
 *     &lt;enumeration value="Sodium(Natrium)"/>
 *     &lt;enumeration value="Sunrise(Horizon)"/>
 *     &lt;enumeration value="Sunset(Rear)"/>
 *     &lt;enumeration value="ExtremeHot"/>
 *     &lt;enumeration value="ExtremeCold"/>
 *     &lt;enumeration value="Underwater"/>
 *     &lt;enumeration value="CloseUp"/>
 *     &lt;enumeration value="Motion"/>
 *     &lt;enumeration value="FlickerFree50"/>
 *     &lt;enumeration value="FlickerFree60"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ImagingPresetType")
@XmlEnum
public enum ImagingPresetType {

    @XmlEnumValue("Custom")
    CUSTOM("Custom"),
    @XmlEnumValue("ClearWeather")
    CLEAR_WEATHER("ClearWeather"),
    @XmlEnumValue("Cloudy")
    CLOUDY("Cloudy"),
    @XmlEnumValue("Fog")
    FOG("Fog"),
    @XmlEnumValue("Rain")
    RAIN("Rain"),
    @XmlEnumValue("Snowing")
    SNOWING("Snowing"),
    @XmlEnumValue("Snow")
    SNOW("Snow"),
    WDR("WDR"),
    @XmlEnumValue("Shade")
    SHADE("Shade"),
    @XmlEnumValue("Night")
    NIGHT("Night"),
    @XmlEnumValue("Indoor")
    INDOOR("Indoor"),
    @XmlEnumValue("Fluorescent")
    FLUORESCENT("Fluorescent"),
    @XmlEnumValue("Incandescent")
    INCANDESCENT("Incandescent"),
    @XmlEnumValue("Sodium(Natrium)")
    SODIUM_NATRIUM("Sodium(Natrium)"),
    @XmlEnumValue("Sunrise(Horizon)")
    SUNRISE_HORIZON("Sunrise(Horizon)"),
    @XmlEnumValue("Sunset(Rear)")
    SUNSET_REAR("Sunset(Rear)"),
    @XmlEnumValue("ExtremeHot")
    EXTREME_HOT("ExtremeHot"),
    @XmlEnumValue("ExtremeCold")
    EXTREME_COLD("ExtremeCold"),
    @XmlEnumValue("Underwater")
    UNDERWATER("Underwater"),
    @XmlEnumValue("CloseUp")
    CLOSE_UP("CloseUp"),
    @XmlEnumValue("Motion")
    MOTION("Motion"),
    @XmlEnumValue("FlickerFree50")
    FLICKER_FREE_50("FlickerFree50"),
    @XmlEnumValue("FlickerFree60")
    FLICKER_FREE_60("FlickerFree60");
    private final String value;

    ImagingPresetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImagingPresetType fromValue(String v) {
        for (ImagingPresetType c: ImagingPresetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
