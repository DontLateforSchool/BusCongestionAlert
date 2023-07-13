package GDSC.DAU.DontLateforSchool.dto.arriveinfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "item")
public class ArriveInfoDto {
    @XmlElement(name = "bstopid")
    private String busStopId; // 정류소ID

    @XmlElement(name = "bstopidx")
    private String sequenceNumber; // 순번

    @XmlElement(name = "nodenm")
    private String busStopName; // 정류소명

    @XmlElement(name = "carno1")
    private String firstVehicleNumber; // 앞차 차량번호

    @XmlElement(name = "min1")
    private Integer remainingFirstTime; // 앞차 남은도착시간(분)

    @XmlElement(name = "station1")
    private Integer remainingFirstStops; // 앞차 남은정류소 수

    @XmlElement(name = "carno2")
    private String secondVehicleNumber; // 뒷차 차량번호

    @XmlElement(name = "min2")
    private Integer remainingSecondTime; // 뒷차 남은도착시간(분)

    @XmlElement(name = "station2")
    private Integer remainingSecondStops; // 뒷차 남은정류소 수

}