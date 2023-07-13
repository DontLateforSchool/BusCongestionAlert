package GDSC.DAU.DontLateforSchool.service;

import GDSC.DAU.DontLateforSchool.domain.Congestion;
import GDSC.DAU.DontLateforSchool.dto.arriveinfo.ArriveInfoDto;
import GDSC.DAU.DontLateforSchool.dto.businfo.BusInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        for (BusInfoDto info: data) {
            if(info.getVehicleNumber()!=null){
                info.setCongestion(Congestion.여유);
            }
        }
        return data;
    }

    /**
     * 노선 정류소 도착정보 조회
     */
    public List<ArriveInfoDto> getArriveInfo(String busStopId){
        return bimsApiService.getBusStopArriveByBusStopIdLineId(busStopId).getData();
    }
}