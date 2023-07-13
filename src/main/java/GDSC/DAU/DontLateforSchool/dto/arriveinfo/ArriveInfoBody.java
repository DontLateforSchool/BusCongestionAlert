package GDSC.DAU.DontLateforSchool.dto.arriveinfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ArriveInfoBody {
    @XmlElement(name = "items")
    private ArriveInfoItems items;
}
