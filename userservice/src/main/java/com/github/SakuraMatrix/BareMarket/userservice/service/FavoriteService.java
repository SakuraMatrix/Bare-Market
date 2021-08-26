package com.github.SakuraMatrix.BareMarket.userservice.service;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Favorite;
import com.github.SakuraMatrix.BareMarket.userservice.domain.FavoriteKey;
import com.github.SakuraMatrix.BareMarket.userservice.repository.FavoriteRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FavoriteService {
    private FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Flux<Favorite> getAll() {
        return favoriteRepository.findAll();
    }

    public Mono<Favorite> add(String symbol) {
        return favoriteRepository.save(new Favorite(new FavoriteKey(1, symbol)));
    }

    // Not supported by AWS Keyspaces
    // public void deleteAll() { 
    //     favoriteRepository.deleteAll().subscribe();
    // }

    public void delete(String symbol) {
        favoriteRepository.deleteById(new FavoriteKey(1, symbol)).subscribe();
    }
}
