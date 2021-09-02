package com.github.SakuraMatrix.BareMarket.portfolio;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StockService {
    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Flux<Stock> getAll(){
        return stockRepository.findAll();
    }

    public Mono<Stock>add(StockInfo stockInfo) {
        return stockRepository.save(new Stock(new StockKey(1, stockInfo.getSymbol(), stockInfo.getTimestamp()), stockInfo.getName(), stockInfo.getPrice()));
    }

    public void delete(String symbol, long timestamp) {
        stockRepository.deleteById(new StockKey(1, symbol, timestamp)).subscribe();
    }

}


