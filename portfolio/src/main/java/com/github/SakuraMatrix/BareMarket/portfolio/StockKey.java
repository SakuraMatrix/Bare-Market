package com.github.SakuraMatrix.BareMarket.portfolio;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class StockKey {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private String symbol;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private long timestamp;

    public StockKey(int id, String symbol, long timestamp) {
        this.id = id;
        this.symbol = symbol;
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
