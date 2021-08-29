package com.github.SakuraMatrix.BareMarket.portfolio;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

//reactive cassandra repository gives me the methods I need
@Repository
public interface StockRepository extends ReactiveCassandraRepository<Stock, StockKey> {
}
