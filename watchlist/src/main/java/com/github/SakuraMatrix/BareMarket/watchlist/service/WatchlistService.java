package com.github.SakuraMatrix.BareMarket.watchlist.service;

import com.github.SakuraMatrix.BareMarket.watchlist.domain.Watchlist;
import com.github.SakuraMatrix.BareMarket.watchlist.domain.WatchlistKey;
import com.github.SakuraMatrix.BareMarket.watchlist.repository.WatchlistRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WatchlistService {
    private WatchlistRepository watchlistRepository;

    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public Flux<Watchlist> getAll() {
        return watchlistRepository.findAll();
    }

    public Mono<Watchlist> add(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

    // // Not supported by AWS Keyspaces
    // public void deleteAll() { 
    //     watchlistRepository.deleteAll().subscribe();
    // }

    public void delete(String symbol) {
        watchlistRepository.deleteById(new WatchlistKey(1, symbol)).subscribe();
    }
}
