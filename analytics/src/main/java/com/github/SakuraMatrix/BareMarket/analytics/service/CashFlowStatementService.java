package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CashFlowStatementService {
    private ObjectMapper objectMapper;
    @Value("${API_KEY}")
    private String API_KEY;
    private WebClient webClient;

    public CashFlowStatementService(WebClient webClient) {
        this.objectMapper = new ObjectMapper();
        this.webClient = webClient;
    }

    public Mono<String> cfsCheck(String symbol) {
        return webClient.get()
                .uri("https://financialmodelingprep.com/api/v3/cash-flow-statement/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
                .retrieve()
                .bodyToMono(String.class);
//                .map(this::deserialize);
    }
}
