package com.github.SakuraMatrix.BareMarket.lookup.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SakuraMatrix.BareMarket.lookup.domain.StockInfo;

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
            .map(s -> s.substring(2, s.length() - 2))
            .map(this::deserialize);
    }

    private StockInfo deserialize(String string) {
        StockInfo stockInfo;
        try {
            stockInfo = objectMapper.readValue(string, StockInfo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            stockInfo = null;
        }
        return stockInfo;
    }
}
