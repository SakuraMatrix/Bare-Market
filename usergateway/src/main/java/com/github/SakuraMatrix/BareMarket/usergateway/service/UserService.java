package com.github.SakuraMatrix.BareMarket.usergateway.service;

import com.github.SakuraMatrix.BareMarket.usergateway.domain.Balance;
import com.github.SakuraMatrix.BareMarket.usergateway.domain.Stock;
import com.github.SakuraMatrix.BareMarket.usergateway.domain.StockInfo;
import com.github.SakuraMatrix.BareMarket.usergateway.domain.StockKey;
import com.github.SakuraMatrix.BareMarket.usergateway.domain.Watchlist;

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

    public Flux<StockInfo> summary() {
        return getWatchlist().flatMap(stock ->  Flux.merge(searchStock(stock.getSymbol())));
    }

    public Mono<Stock> buy(String symbol) {
        Mono<StockInfo> stockInfo = searchStock(symbol);

        stockInfo.subscribe(info -> 
            getBalance().subscribe(balance -> 
                adjustBalance(balance.getBalance(), info.getPrice(), true)
                    .subscribe(response -> insertIntoDB(info).subscribe())
            )
        );

        return stockInfo.map(info -> new Stock(new StockKey(1, info.getSymbol(), info.getTimestamp()), info.getName(), info.getPrice()));
    }

    public Mono<Stock> sell(String symbol, long timestamp) {
        Mono<StockInfo> stockInfo = searchStock(symbol);

        stockInfo.subscribe(info -> {
            removeFromDB(symbol, timestamp).subscribe();
                    
            getBalance().subscribe(balance ->
                adjustBalance(balance.getBalance(), info.getPrice(), false)
                    .subscribe());
        });

        return stockInfo.map(info -> new Stock(new StockKey(1, info.getSymbol(), timestamp), info.getName(), info.getPrice()));
    }

    private Flux<Watchlist> getWatchlist() {
        return webClient.get()
            .uri("localhost:8080/watchlists")
            .retrieve()
            .bodyToFlux(Watchlist.class);
    }

    private Mono<StockInfo> searchStock(String symbol) {
        return webClient.get()
            .uri("localhost:8080/search/{symbol}", symbol)
            .retrieve()
            .bodyToMono(StockInfo.class);
    }

    private Mono<Balance> getBalance() {
        return webClient.get()
            .uri("localhost:8080/balances")
            .retrieve()
            .bodyToMono(Balance.class);
    }

    private Mono<Balance> adjustBalance(double balance, double amount, boolean buy) {
        double newBalance = buy ? balance - amount : balance + amount;
        return webClient.put()
            .uri("localhost:8080/balances")
            .body(Mono.just(newBalance), Double.class)
            .retrieve()
            .bodyToMono(Balance.class);
    }

    private Mono<Stock> insertIntoDB(StockInfo stockInfo) {
        return webClient.post()
            .uri("localhost:8080/stocks")
            .body(Mono.just(stockInfo), StockInfo.class)
            .retrieve()
            .bodyToMono(Stock.class);
    }

    private Mono<Void> removeFromDB(String symbol, long timestamp) {
        return webClient.delete()
            .uri("localhost:8080/stocks/{symbol}/{timestamp}", symbol, String.valueOf(timestamp))
            .retrieve()
            .bodyToMono(Void.class);
    }
}
