package com.github.SakuraMatrix.BareMarket.watchlist.domain;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class WatchlistKey implements Serializable {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private String symbol;

    public WatchlistKey(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
