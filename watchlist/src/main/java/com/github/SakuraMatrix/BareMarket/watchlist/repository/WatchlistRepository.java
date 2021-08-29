package com.github.SakuraMatrix.BareMarket.watchlist.repository;

import com.github.SakuraMatrix.BareMarket.watchlist.domain.Watchlist;
import com.github.SakuraMatrix.BareMarket.watchlist.domain.WatchlistKey;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface WatchlistRepository extends ReactiveCassandraRepository <Watchlist, WatchlistKey> {
    
}
