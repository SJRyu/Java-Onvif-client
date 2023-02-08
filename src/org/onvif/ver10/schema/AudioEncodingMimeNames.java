
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudioEncodingMimeNames.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AudioEncodingMimeNames">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PCMU"/>
 *     &lt;enumeration value="G726"/>
 *     &lt;enumeration value="MP4A-LATM"/>
 *     &lt;enumeration value="mpeg4-generic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AudioEncodingMimeNames")
@XmlEnum
public enum AudioEncodingMimeNames {

    PCMU("PCMU"),
    @XmlEnumValue("G726")
    G_726("G726"),
    @XmlEnumValue("MP4A-LATM")
    MP_4_A_LATM("MP4A-LATM"),
    @XmlEnumValue("mpeg4-generic")
    MPEG_4_GENERIC("mpeg4-generic");
    private final String value;

    AudioEncodingMimeNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AudioEncodingMimeNames fromValue(String v) {
        for (AudioEncodingMimeNames c: AudioEncodingMimeNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
