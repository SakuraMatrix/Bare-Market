package com.github.SakuraMatrix.BareMarket.analytics.domain;

public class CompanyEnterpriseValue {
    private String symbol;
    private String date;
    private double stockPrice;
    private int numberOfShares;
    private double marketCapitalization;

    private int minusCashAndCashEquivalents;
    private int addTotalDebt;
    private double enterpriseValue;
    private String link;
    private String finalLink;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFinalLink() {
        return finalLink;
    }

    public void setFinalLink(String finalLink) {
        this.finalLink = finalLink;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public double getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(double marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public int getMinusCashAndCashEquivalents() {
        return minusCashAndCashEquivalents;
    }

    public void setMinusCashAndCashEquivalents(int minusCashAndCashEquivalents) {
        this.minusCashAndCashEquivalents = minusCashAndCashEquivalents;
    }

    public int getAddTotalDebt() {
        return addTotalDebt;
    }

    public void setAddTotalDebt(int addTotalDebt) {
        this.addTotalDebt = addTotalDebt;
    }

    public double getEnterpriseValue() {
        return enterpriseValue;
    }

    public void setEnterpriseValue(double enterpriseValue) {
        this.enterpriseValue = enterpriseValue;
    }
}
