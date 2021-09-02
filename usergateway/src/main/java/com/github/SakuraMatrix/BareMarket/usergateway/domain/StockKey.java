package com.github.SakuraMatrix.BareMarket.usergateway.domain;

import java.io.Serializable;

public class StockKey implements Serializable{
    private int id;
    private String symbol;
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
