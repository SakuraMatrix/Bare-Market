package com.github.SakuraMatrix.BareMarket.userservice.controller;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Balance;
import com.github.SakuraMatrix.BareMarket.userservice.service.BalanceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/balances")
public class BalanceController {

    private BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping()
    public Mono<Balance> getBalance() {
        return balanceService.get();
    } // GET request with curl: curl localhost:8080/balances

    @PutMapping()
    public Mono<Balance> adjustBalance(@RequestBody double balance) {
        return balanceService.set(balance);
    } // PUT request with curl: curl -X PUT -H "Content-Type: application/json" -d "1" localhost:8080/balances
}
