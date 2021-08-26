package com.github.SakuraMatrix.BareMarket.userservice.controller;

import com.github.SakuraMatrix.BareMarket.userservice.Domain.Balance;
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
    } // make a GET request with: curl localhost:8080/balances

    @PutMapping()
    public Mono<Balance> adjustBalance(@RequestBody Balance balance) {
        return balanceService.set(balance);
    } // make a PUT request with: curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "balance": 5}' localhost:8080/balances
}
