package com.github.SakuraMatrix.BareMarket.userservice.service;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Balance;
import com.github.SakuraMatrix.BareMarket.userservice.domain.StockInfo;
import com.github.SakuraMatrix.BareMarket.userservice.domain.Watchlist;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<StockInfo> searchStock(String symbol) {
        return webClient.get()
            .uri("localhost:8081/search/{symbol}", symbol) // StockLookupService service started on port 8081
            .retrieve()
            .bodyToMono(StockInfo.class);
    }

    public Flux<Watchlist> getWatchlist() {
        return webClient.get()
            .uri("localhost:8082/watchlists") // Watchlist service started on port 8082
            .retrieve()
            .bodyToFlux(Watchlist.class);
    }

    public Mono<Watchlist> addToWatchlist(String symbol) {
        return webClient.post()
            .uri("localhost:8082/watchlists")
            .body(Mono.just(symbol), String.class)
            .retrieve()
            .bodyToMono(Watchlist.class);
    }

    public void deleteFromWatchlist(String symbol) {
        webClient.delete()
            .uri("localhost:8082/watchlists/{symbol}", symbol)
            .retrieve()
            .bodyToMono(Void.class)
            .subscribe();
    }

    public Mono<Balance> getBalance() {
        return webClient.get()
            .uri("localhost:8083/balances") // Balance service started on port 8083
            .retrieve()
            .bodyToMono(Balance.class);
    }

    public Mono<Balance> setBalance(double balance) {
        return webClient.put()
            .uri("localhost:8083/balances")
            .body(Mono.just(balance), Double.class)
            .retrieve()
            .bodyToMono(Balance.class);
    }
}
