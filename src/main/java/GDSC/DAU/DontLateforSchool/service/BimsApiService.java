package GDSC.DAU.DontLateforSchool.service;

import GDSC.DAU.DontLateforSchool.dto.arriveinfo.ArriveInfoResponse;
import GDSC.DAU.DontLateforSchool.dto.businfo.BusInfoResponse;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class BimsApiService {
    private static final String API_KEY = URLDecoder.decode("", StandardCharsets.UTF_8);
    private static final String API_HOST = "https://apis.data.go.kr/6260000/BusanBIMS";
    private static final Integer MAX_IN_MEMORY_SIZE = 1024 * 1024 * 10; // 10MB
    private static final String LINE_ID = "5291010000"; // 노선 ID(사하 10)

    private final WebClient webClient;

    public BimsApiService(WebClient.Builder webClientBuilder) {
        // 처리할 수 있는 용량 설정
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(MAX_IN_MEMORY_SIZE))
                .build();
        //SSL 인증을 무시하는 로직
        HttpClient httpClient = HttpClient.create()
                .secure(sslContextSpec -> sslContextSpec.sslContext(
                        SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE)
                ));

        this.webClient = webClientBuilder
                .baseUrl(API_HOST)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(strategies)
                .build();
    }

    /**
     * 노선 정류소 조회
     * (노선ID를 검색조건으로 노선 정보 및 실시간 버스 위치정보를 제공)
     */
    public BusInfoResponse getBusInfoByRouteId() {
        Mono<BusInfoResponse> busInfoListMono = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/busInfoByRouteId")
                        .queryParam("lineid", LINE_ID)
                        .queryParam("serviceKey", API_KEY)
                        .build())
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(BusInfoResponse.class);

        return performRequest(busInfoListMono);
    }


    /**
     * 노선 정류소 도착정보 조회
     */
    public ArriveInfoResponse getBusStopArriveByBusStopIdLineId(String busStopId) {
        Mono<ArriveInfoResponse> busInfoListMono = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/busStopArrByBstopidLineid")
                        .queryParam("bstopid", busStopId)
                        .queryParam("lineid", LINE_ID)
                        .queryParam("serviceKey", API_KEY)
                        .build())
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(ArriveInfoResponse.class);

        return performRequest(busInfoListMono);
    }

    private <T> T performRequest(Mono<T> requestMono) {
        try {
            return requestMono.block();
        } catch (WebClientException webClientException) {
            log.error(webClientException.getMessage());
            throw new RuntimeException("DATA.GO.KR와 연동에 실패했습니다.");
        }
    }

}