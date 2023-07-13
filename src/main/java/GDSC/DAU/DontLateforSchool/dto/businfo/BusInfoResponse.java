package GDSC.DAU.DontLateforSchool.dto.businfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@Data
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusInfoResponse {
    @XmlElement(name = "body")
    private BusInfoBody busInfoBody;

    public List<BusInfoDto> getData() {
        return busInfoBody.getItems().getBusInfoDtos();
    }
}
