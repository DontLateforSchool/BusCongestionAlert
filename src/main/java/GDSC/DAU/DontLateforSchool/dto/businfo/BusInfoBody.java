package GDSC.DAU.DontLateforSchool.dto.businfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BusInfoBody {
    @XmlElement(name = "items")
    private BusInfoItems items;
}
