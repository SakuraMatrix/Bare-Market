package com.github.SakuraMatrix.BareMarket.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SakuraMatrix.BareMarket.userservice.domain.StockInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class StockLookupService {
    private ObjectMapper objectMapper;
    @Value("${API_KEY}")
    private String API_KEY;
    private WebClient webClient;

    public StockLookupService(WebClient webClient) {
        this.objectMapper = new ObjectMapper();
        this.webClient = webClient;
    }

    public Mono<StockInfo> search(String symbol) {
        return webClient.get()
            .uri("https://financialmodelingprep.com/api/v3/quote/{symbol}?apikey={API_KEY}", symbol, API_KEY)
            .retrieve()
            .bodyToMono(String.class)
            .map(this::deserialize);
    }

    private StockInfo deserialize(String string) {
        StockInfo stockInfo;
        String stockString = string.substring(2, string.length() - 2);
        try {
            stockInfo = objectMapper.readValue(stockString, StockInfo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            stockInfo = null;
        }
        return stockInfo;
    }
}
