package GDSC.DAU.DontLateforSchool.dto.arriveinfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArriveInfoResponse {
    @XmlElement(name = "body")
    private ArriveInfoBody arriveInfoBody;

    public List<ArriveInfoDto> getData() {
        return arriveInfoBody.getItems().getArriveInfoDtos();
    }
}
