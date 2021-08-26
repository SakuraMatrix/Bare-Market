package com.github.SakuraMatrix.BareMarket.userservice.repository;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Balance;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends ReactiveCassandraRepository<Balance, Integer> {
    
}
