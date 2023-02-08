
package org.onvif.ver10.deviceio.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParityBit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParityBit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Even"/>
 *     &lt;enumeration value="Odd"/>
 *     &lt;enumeration value="Mark"/>
 *     &lt;enumeration value="Space"/>
 *     &lt;enumeration value="Extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParityBit")
@XmlEnum
public enum ParityBit {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Even")
    EVEN("Even"),
    @XmlEnumValue("Odd")
    ODD("Odd"),
    @XmlEnumValue("Mark")
    MARK("Mark"),
    @XmlEnumValue("Space")
    SPACE("Space"),
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    ParityBit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParityBit fromValue(String v) {
        for (ParityBit c: ParityBit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
