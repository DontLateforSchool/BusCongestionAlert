package GDSC.DAU.DontLateforSchool.dto.businfo;

import GDSC.DAU.DontLateforSchool.domain.Congestion;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "item")
public class BusInfoDto {
    @XmlElement(name = "bstopidx")
    private String busStopIdx; // 정류소 번호

    @XmlElement(name = "bstopnm")
    private String busStopName; // 정류소 명

    @XmlElement(name = "carno")
    private String vehicleNumber; // 버스 차량번호

    private Congestion congestion;  //혼잡도
}