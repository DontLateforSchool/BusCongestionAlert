package GDSC.DAU.DontLateforSchool.dto.arriveinfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ArriveInfoItems {
    @XmlElement(name = "item")
    private List<ArriveInfoDto> arriveInfoDtos;
}
