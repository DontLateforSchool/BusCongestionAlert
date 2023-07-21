package GDSC.DAU.DontLateforSchool.service;

import GDSC.DAU.DontLateforSchool.domain.Congestion;
import GDSC.DAU.DontLateforSchool.dto.arriveinfo.ArriveInfoDto;
import GDSC.DAU.DontLateforSchool.dto.businfo.BusInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BimsService {
    private final BimsApiService bimsApiService;

    /**
     * 노선 정류소 조회
     * 노선 정보 및 실시간 버스 위치정보를 제공
     */
    public List<BusInfoDto> getBusInfo() {
        List<BusInfoDto> data = bimsApiService.getBusInfoByRouteId().getData();
        List<Integer> congestionData = new ArrayList<>(List.of(0,0,0,0,0,0,4,37,185,159,168,192,149,189,280,205,314,243,145,72,59,73,36));
        //현재 시간 가져오기
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        for (BusInfoDto info : data) {
            if (info.getVehicleNumber() != null) {
                if(hour>=6 && hour <= 22){
                    if(congestionData.get(hour) / 3 >= 56){
                        info.setCongestion(Congestion.HIGH);
                    }
                    else if(congestionData.get(hour) / 3 < 56 && congestionData.get(hour) / 3 > 21){
                        info.setCongestion(Congestion.NORMAL);
                    }
                    else {
                        info.setCongestion(Congestion.LOW);
                    }
                }

            }
        }

        return data;
    }

    /**
     * 노선 정류소 도착정보 조회
     */
    public List<ArriveInfoDto> getArriveInfo(String busStopId) {
        return bimsApiService.getBusStopArriveByBusStopIdLineId(busStopId).getData();
    }
}