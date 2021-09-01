package com.github.SakuraMatrix.BareMarket.userservice.controller;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Balance;
import com.github.SakuraMatrix.BareMarket.userservice.domain.StockInfo;
import com.github.SakuraMatrix.BareMarket.userservice.domain.Watchlist;
import com.github.SakuraMatrix.BareMarket.userservice.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Mono<String> test() {
        return Mono.just("test");
    }

    @GetMapping("/search/{symbol}")
    public Mono<StockInfo> searchStock(@PathVariable String symbol) {
        return userService.searchStock(symbol);
    }

    @GetMapping("/watchlists")
    public Flux<Watchlist> getWatchlist() {
        return userService.getWatchlist();
    }

    @PostMapping("/watchlists")
    public Mono<Watchlist> addToWatchlist(@RequestBody String symbol) {
        return userService.addToWatchlist(symbol);
    }

    @DeleteMapping("/watchlists/{symbol}")
    public void deleteFromWatchlist(@PathVariable String symbol) {
        userService.deleteFromWatchlist(symbol);
    }

    @GetMapping("/balances")
    public Mono<Balance> getBalance() {
        return userService.getBalance();
    }

    @PutMapping("/balances")
    public Mono<Balance> setBalance(@RequestBody double balance) {
        return userService.setBalance(balance);
    }
}
