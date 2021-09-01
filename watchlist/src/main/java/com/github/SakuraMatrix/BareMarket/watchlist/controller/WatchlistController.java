package com.github.SakuraMatrix.BareMarket.watchlist.controller;

import com.github.SakuraMatrix.BareMarket.watchlist.domain.Watchlist;
import com.github.SakuraMatrix.BareMarket.watchlist.service.WatchlistService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/watchlists")
public class WatchlistController {
    private WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @GetMapping()
    public Flux<Watchlist> getAll() {
        return watchlistService.getAll();
    } // GET request with curl: curl localhost:8080/watchlists

    @PostMapping()
    public Mono<Watchlist> add(@RequestBody String symbol) {
        return watchlistService.add(symbol);
    } // POST request with curl: curl -X POST -H "Content-Type: application/json" -d "GOOGL" localhost:8080/watchlists

    // // Not supported by AWS Keyspaces
    // @DeleteMapping()
    // public void deleteAll() {
    //     watchlistService.deleteAll();
    // }

    @DeleteMapping("/{symbol}")
    public void delete(@PathVariable String symbol) {
        watchlistService.delete(symbol);
    } // DELETE request with curl: curl -X DELETE localhost:8080/watchlists/GOOGL
}
