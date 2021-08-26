package com.github.SakuraMatrix.BareMarket.userservice.controller;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Favorite;
import com.github.SakuraMatrix.BareMarket.userservice.service.FavoriteService;

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
@RequestMapping("/favorites")
public class FavoriteController {
    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping()
    public Flux<Favorite> getAll() {
        return favoriteService.getAll();
    }

    @PostMapping()
    public Mono<Favorite> add(@RequestBody String symbol) {
        return favoriteService.add(symbol);
    }

    // Not supported by AWS Keyspaces
    // @DeleteMapping()
    // public void deleteAll() {
    //     favoriteService.deleteAll();
    // }

    @DeleteMapping("/{symbol}")
    public void delete(@PathVariable String symbol) {
        favoriteService.delete(symbol);
    }
}
