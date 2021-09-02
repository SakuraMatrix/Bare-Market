package com.github.SakuraMatrix.BareMarket.balance.repository;

import com.github.SakuraMatrix.BareMarket.balance.domain.Balance;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends ReactiveCassandraRepository<Balance, Integer> {
    
}
