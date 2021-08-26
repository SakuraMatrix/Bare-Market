package com.github.SakuraMatrix.BareMarket.userservice.service;

import com.github.SakuraMatrix.BareMarket.userservice.Domain.Balance;
import com.github.SakuraMatrix.BareMarket.userservice.repository.BalanceRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class BalanceService {
    private BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Mono<Balance> get() {
        return balanceRepository.findById(1);
    }

    public Mono<Balance> set(Balance balance) {
        return balanceRepository.save(balance);
    }
}
