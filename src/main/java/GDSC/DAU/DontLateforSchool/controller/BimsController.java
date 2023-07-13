package GDSC.DAU.DontLateforSchool.controller;

import GDSC.DAU.DontLateforSchool.dto.arriveinfo.ArriveInfoDto;
import GDSC.DAU.DontLateforSchool.dto.businfo.BusInfoDto;
import GDSC.DAU.DontLateforSchool.service.BimsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequiredArgsConstructor
public class BimsController {

    private final BimsService bimsService;

    /**
     * 노선 정류소 조회
     * 노선 정보 및 실시간 버스 위치정보를 제공
     */
    @GetMapping("/busInfo")
    public List<BusInfoDto> getBusInfo() {
        return bimsService.getBusInfo();
    }

    /**
     * 노선 정류소 도착정보 조회
     */
    @GetMapping("/arriveInfo")
    public List<ArriveInfoDto> getArriveInfo(@RequestParam String busStopId) {
        return bimsService.getArriveInfo(busStopId);
    }

}