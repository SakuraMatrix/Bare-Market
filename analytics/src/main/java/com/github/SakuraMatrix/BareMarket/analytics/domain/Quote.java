package com.github.SakuraMatrix.BareMarket.analytics.domain;

import java.math.BigDecimal;

public class Quote {
    private String symbol; //************ 1
    private String name; //************ 2
    private double price;
    private double changesPercentage;
    private double change;

    private double dayLow;
    private double dayHigh;
    private double yearHigh;
    private double yearLow;
    private BigDecimal marketCap;

    private double priceAvg50;
    private double priceAvg200;
    private long volume;
    private long avgVolume;
    private String exchange;

    private double open;
    private double previousClose;
    private double eps; //************ 3
    private double pe; //************ 4
    private String earningsAnnouncement;

    private double sharesOutstanding;
    private long timestamp;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public double getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(double changesPercentage) {
        this.changesPercentage = changesPercentage;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getDayLow() {
        return dayLow;
    }

    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    }

    public double getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }

    public double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public double getYearLow() {
        return yearLow;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public double getPriceAvg50() {
        return priceAvg50;
    }

    public void setPriceAvg50(double priceAvg50) {
        this.priceAvg50 = priceAvg50;
    }

    public double getPriceAvg200() {
        return priceAvg200;
    }

    public void setPriceAvg200(double priceAvg200) {
        this.priceAvg200 = priceAvg200;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getAvgVolume() {
        return avgVolume;
    }

    public void setAvgVolume(long avgVolume) {
        this.avgVolume = avgVolume;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public String getEarningsAnnouncement() {
        return earningsAnnouncement;
    }

    public void setEarningsAnnouncement(String earningsAnnouncement) {
        this.earningsAnnouncement = earningsAnnouncement;
    }

    public double getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(double sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
