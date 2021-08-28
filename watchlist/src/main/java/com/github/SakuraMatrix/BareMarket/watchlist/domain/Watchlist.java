package com.github.SakuraMatrix.BareMarket.watchlist.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("watchlists")
public class Watchlist {
    @PrimaryKey
    private WatchlistKey key;

    public Watchlist (WatchlistKey key) {
        this.key = key;
    }

    public int getId() {
        return key.getId();
    }

    public String getSymbol() {
        return key.getSymbol();
    }

    public void setId(int id) {
        this.key.setId(id);
    }

    public void setSymbol(String symbol) {
        this.key.setSymbol(symbol);
    }
}
