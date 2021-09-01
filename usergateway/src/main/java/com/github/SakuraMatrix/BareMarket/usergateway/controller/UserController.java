package com.github.SakuraMatrix.BareMarket.usergateway.controller;

import com.github.SakuraMatrix.BareMarket.usergateway.domain.Stock;
import com.github.SakuraMatrix.BareMarket.usergateway.domain.StockInfo;
import com.github.SakuraMatrix.BareMarket.usergateway.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/summaries")
    public Flux<StockInfo> summary() {
        return userService.summary();
    }

    @PostMapping("/holdings")
    public Mono<Stock> buy(@RequestBody String symbol) {
        return userService.buy(symbol);
    }

    @DeleteMapping("/holdings/{symbol}/{timestamp}")
    public Mono<Stock> sell(@PathVariable String symbol, @PathVariable long timestamp) {
        return userService.sell(symbol, timestamp);
    }
}
