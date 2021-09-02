package com.github.SakuraMatrix.BareMarket.usergateway.domain;

public class Watchlist {
    private int id;
    private String symbol;

    public Watchlist() {

    }
    
    public Watchlist(int id, String symbol) {
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
