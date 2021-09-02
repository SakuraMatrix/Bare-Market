package com.github.SakuraMatrix.BareMarket.usergateway.domain;

public class Stock {

    private StockKey stockKey;
    private String name;
    private double price;

    public Stock(StockKey stockKey, String name, double price) {
        this.stockKey = stockKey;
        this.name = name;
        this.price = price;
    }

    public Stock() {}

    public String getSymbol() {
        return stockKey.getSymbol();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public long getTimestamp() {
        return stockKey.getTimestamp();
    }

    public long getId() {
        return stockKey.getId();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
         this.name = name;
    }

    public void setStockKey(StockKey stockKey) {
        this.stockKey = stockKey;
    }
}

