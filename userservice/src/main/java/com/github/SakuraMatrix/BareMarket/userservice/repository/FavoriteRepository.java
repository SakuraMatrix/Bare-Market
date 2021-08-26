package com.github.SakuraMatrix.BareMarket.userservice.repository;

import com.github.SakuraMatrix.BareMarket.userservice.domain.Favorite;
import com.github.SakuraMatrix.BareMarket.userservice.domain.FavoriteKey;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface FavoriteRepository extends ReactiveCassandraRepository <Favorite, FavoriteKey> {
    
}
