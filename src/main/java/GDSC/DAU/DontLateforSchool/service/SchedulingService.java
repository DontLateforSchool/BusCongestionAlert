//package GDSC.DAU.DontLateforSchool.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class SchedulingService {
//    private final BimsService bimsService;
//    private final String busStopid = "209030102";  //
//
//    // 6초 마다 각 버스 정류장 도착 정보 업데이트
//    @Scheduled(fixedRate = 6000)
//    public void updateBusArrival() {
//        bimsService.getBusInfo();
//        bimsService.getArriveInfo(busStopid);
//        //db로직 추가
//    }
//}
