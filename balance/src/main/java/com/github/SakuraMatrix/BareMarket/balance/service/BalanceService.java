package com.github.SakuraMatrix.BareMarket.balance.service;

import com.github.SakuraMatrix.BareMarket.balance.domain.Balance;
import com.github.SakuraMatrix.BareMarket.balance.repository.BalanceRepository;

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

    public Mono<Balance> set(double balance) {
        return balanceRepository.save(new Balance(1, balance));
    }
}
