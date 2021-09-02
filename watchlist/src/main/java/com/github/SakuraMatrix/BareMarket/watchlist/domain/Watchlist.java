package com.github.SakuraMatrix.BareMarket.watchlist.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("watchlists")
public class Watchlist {
    @PrimaryKey
    private WatchlistKey watchlistKey;

    public Watchlist() {

    }

    public Watchlist (WatchlistKey watchlistKey) {
        this.watchlistKey = watchlistKey;
    }

    public int getId() {
        return watchlistKey.getId();
    }

    public String getSymbol() {
        return watchlistKey.getSymbol();
    }

    public void setId(int id) {
        this.watchlistKey.setId(id);
    }

    public void setSymbol(String symbol) {
        this.watchlistKey.setSymbol(symbol);
    }

    public void setWatchlistKey(WatchlistKey watchlistKey) {
        this.watchlistKey = watchlistKey;
    }
}
