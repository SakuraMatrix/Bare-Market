package com.github.SakuraMatrix.BareMarket.portfolio;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController //Controller defines routes
@RequestMapping(value = "/stocks") //applies this url to the beginning of all my urls
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping()
    public Flux<Stock> getAll(){
        return stockService.getAll();
    }// GET request with curl: curl localhost:8080/stocks

    @PostMapping()
    public Mono<Stock>add(@RequestBody Stock stock){
        return stockService.add(stock.getSymbol(), stock.getTimestamp(), stock.getName(), stock.getPrice());
    }

    @DeleteMapping("/{symbol}/{timestamp}")
    public void delete(@PathVariable String symbol, @PathVariable long timestamp){
        stockService.delete(symbol, timestamp); // DELETE request with curl: curl -X DELETE localhost:8080/stocks/TSLA/1
    }
}
