package com.github.SakuraMatrix.BareMarket.analytics.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SakuraMatrix.BareMarket.analytics.domain.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class PillarService {
    private ObjectMapper objectMapper;
    @Value("${API_KEY}")
    private String API_KEY;
    private WebClient webClient;

    public PillarService(WebClient webClient){
        this.objectMapper = new ObjectMapper();
        this.webClient = webClient;
    }

    public Mono<Pillar> pillarOne(String symbol) throws IOException {

        return webClient.get()
                .uri("https://financialmodelingprep.com/api/v3/quote/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
                .retrieve()
                .bodyToMono(String.class)
                .map(this::deserialize);
    }

    private Pillar deserialize(String string){
        Pillar pillar;
        String pillarString = string.substring(2, string.length()-2);
        try {
            pillar = objectMapper.readValue(pillarString, Pillar.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            pillar = null;
        }
        return pillar;
    }

//    public Mono<String> bssCheck(String symbol) {
//        return webClient.get()
//                .uri("https://financialmodelingprep.com/api/v3/balance-sheet-statement/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
//                .retrieve()
//                .bodyToMono(String.class);
//                .map(this::deserialize);
//    }

//    public Mono<String> cfsCheck(String symbol) {
//        return webClient.get()
//                .uri("https://financialmodelingprep.com/api/v3/cash-flow-statement/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
//                .retrieve()
//                .bodyToMono(String.class);
////                .map(this::deserialize);
//    }

//    public Mono<String> cveCheck(String symbol) {
//        return webClient.get()
//                .uri("https://financialmodelingprep.com/api/v3/enterprise-values/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
//                .retrieve()
//                .bodyToMono(String.class);
////                .map(this::deserialize);
//    }

//    public Mono<String> isCheck(String symbol) {
//        return webClient.get()
//                .uri("https://financialmodelingprep.com/api/v3/income-statement/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
//                .retrieve()
//                .bodyToMono(String.class);
////                .map(this::deserialize);
//    }
}
