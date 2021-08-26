package com.github.SakuraMatrix.BareMarket.userservice.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("favorites")
public class Favorite {
    @PrimaryKey
    private FavoriteKey key;

    public Favorite (FavoriteKey key) {
        this.key = key;
    }

    public int getId() {
        return key.getId();
    }

    public String getSymbol() {
        return key.getSymbol();
    }
}
