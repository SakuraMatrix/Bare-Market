package com.github.SakuraMatrix.BareMarket.portfolio;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("holdings")
public class Stock {

    @PrimaryKey
    private StockKey stockKey;
    private String name;
    private double price;

    public Stock(StockKey stockKey, String name, double price) {
        this.stockKey = stockKey;
        this.name = name;
        this.price = price;
    }

    public Stock() {
    }

    public String getSymbol() {
        return stockKey.getSymbol();
    }

    public void setSymbol(String symbol) {
        this.stockKey.setSymbol(symbol);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTimestamp() {
        return stockKey.getTimestamp();
    }

    public void setTimestamp(long timestamp) {
        this.stockKey.setTimestamp(timestamp);
    }
    public long getId() {
        return stockKey.getId();
    }

    public void setId(int id) {
        this.stockKey.setId(id);
    }

}

