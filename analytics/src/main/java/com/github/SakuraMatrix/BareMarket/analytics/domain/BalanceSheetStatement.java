package com.github.SakuraMatrix.BareMarket.analytics.domain;

public class BalanceSheetStatement {

    private String date; //********************** 1
    private String symbol; //********************** 2
    private String fillingDate;
    private String acceptedDate;
    private String period;

    private int cashAndCashEquivalents;
    private int shortTermInvestments;
    private int cashAndShortTermInvestments;
    private int netReceivables;
    private int inventory;

    private int otherCurrentAssets;
    private int totalCurrentAssets;
    private int propertyPlantEquipmentNet;
    private double goodwill;
    private double intangibleAssets;

    private double goodwillAndIntangibleAssets;
    private int longTermInvestments;
    private double taxAssets;
    private int otherNonCurrentAssets;
    private int totalNonCurrentAssets;

    private int otherAssets;
    private int totalAssets;
    private int accountPayables;
    private int shortTermDebt;
    private double taxPayables;

    private int deferredRevenue;
    private int otherCurrentLiabilities;
    private int totalCurrentLiabilities;
    private long longTermDebt; //********************** 3
    private double deferredRevenueNonCurrent;

    private double deferredTaxLiabilitiesNonCurrent;
    private int otherNonCurrentLiabilities;
    private int totalNonCurrentLiabilities;
    private int otherLiabilities;
    private int totalLiabilities;

    private int commonStock;
    private int retainedEarnings;
    private int accumulatedOtherComprehensiveIncomeLoss;
    private int othertotalStockholdersEquity;
    private int totalStockholdersEquity;

    private long totalLiabilitiesAndStockholdersEquity; //********************** 4
    private int totalInvestments;
    private long totalDebt; //********************** 5
    private int netDebt;
    private String link;

    private String finalLink;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(String fillingDate) {
        this.fillingDate = fillingDate;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getCashAndCashEquivalents() {
        return cashAndCashEquivalents;
    }

    public void setCashAndCashEquivalents(int cashAndCashEquivalents) {
        this.cashAndCashEquivalents = cashAndCashEquivalents;
    }

    public int getShortTermInvestments() {
        return shortTermInvestments;
    }

    public void setShortTermInvestments(int shortTermInvestments) {
        this.shortTermInvestments = shortTermInvestments;
    }

    public int getCashAndShortTermInvestments() {
        return cashAndShortTermInvestments;
    }

    public void setCashAndShortTermInvestments(int cashAndShortTermInvestments) {
        this.cashAndShortTermInvestments = cashAndShortTermInvestments;
    }

    public int getNetReceivables() {
        return netReceivables;
    }

    public void setNetReceivables(int netReceivables) {
        this.netReceivables = netReceivables;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    public void setOtherCurrentAssets(int otherCurrentAssets) {
        this.otherCurrentAssets = otherCurrentAssets;
    }

    public int getTotalCurrentAssets() {
        return totalCurrentAssets;
    }

    public void setTotalCurrentAssets(int totalCurrentAssets) {
        this.totalCurrentAssets = totalCurrentAssets;
    }

    public int getPropertyPlantEquipmentNet() {
        return propertyPlantEquipmentNet;
    }

    public void setPropertyPlantEquipmentNet(int propertyPlantEquipmentNet) {
        this.propertyPlantEquipmentNet = propertyPlantEquipmentNet;
    }

    public double getGoodwill() {
        return goodwill;
    }

    public void setGoodwill(double goodwill) {
        this.goodwill = goodwill;
    }

    public double getIntangibleAssets() {
        return intangibleAssets;
    }

    public void setIntangibleAssets(double intangibleAssets) {
        this.intangibleAssets = intangibleAssets;
    }

    public double getGoodwillAndIntangibleAssets() {
        return goodwillAndIntangibleAssets;
    }

    public void setGoodwillAndIntangibleAssets(double goodwillAndIntangibleAssets) {
        this.goodwillAndIntangibleAssets = goodwillAndIntangibleAssets;
    }

    public int getLongTermInvestments() {
        return longTermInvestments;
    }

    public void setLongTermInvestments(int longTermInvestments) {
        this.longTermInvestments = longTermInvestments;
    }

    public double getTaxAssets() {
        return taxAssets;
    }

    public void setTaxAssets(double taxAssets) {
        this.taxAssets = taxAssets;
    }

    public int getOtherNonCurrentAssets() {
        return otherNonCurrentAssets;
    }

    public void setOtherNonCurrentAssets(int otherNonCurrentAssets) {
        this.otherNonCurrentAssets = otherNonCurrentAssets;
    }

    public int getTotalNonCurrentAssets() {
        return totalNonCurrentAssets;
    }

    public void setTotalNonCurrentAssets(int totalNonCurrentAssets) {
        this.totalNonCurrentAssets = totalNonCurrentAssets;
    }

    public int getOtherAssets() {
        return otherAssets;
    }

    public void setOtherAssets(int otherAssets) {
        this.otherAssets = otherAssets;
    }

    public int getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(int totalAssets) {
        this.totalAssets = totalAssets;
    }

    public int getAccountPayables() {
        return accountPayables;
    }

    public void setAccountPayables(int accountPayables) {
        this.accountPayables = accountPayables;
    }

    public int getShortTermDebt() {
        return shortTermDebt;
    }

    public void setShortTermDebt(int shortTermDebt) {
        this.shortTermDebt = shortTermDebt;
    }

    public double getTaxPayables() {
        return taxPayables;
    }

    public void setTaxPayables(double taxPayables) {
        this.taxPayables = taxPayables;
    }

    public int getDeferredRevenue() {
        return deferredRevenue;
    }

    public void setDeferredRevenue(int deferredRevenue) {
        this.deferredRevenue = deferredRevenue;
    }

    public int getOtherCurrentLiabilities() {
        return otherCurrentLiabilities;
    }

    public void setOtherCurrentLiabilities(int otherCurrentLiabilities) {
        this.otherCurrentLiabilities = otherCurrentLiabilities;
    }

    public int getTotalCurrentLiabilities() {
        return totalCurrentLiabilities;
    }

    public void setTotalCurrentLiabilities(int totalCurrentLiabilities) {
        this.totalCurrentLiabilities = totalCurrentLiabilities;
    }

    public long getLongTermDebt() {
        return longTermDebt;
    }

    public void setLongTermDebt(long longTermDebt) {
        this.longTermDebt = longTermDebt;
    }

    public double getDeferredRevenueNonCurrent() {
        return deferredRevenueNonCurrent;
    }

    public void setDeferredRevenueNonCurrent(double deferredRevenueNonCurrent) {
        this.deferredRevenueNonCurrent = deferredRevenueNonCurrent;
    }

    public double getDeferredTaxLiabilitiesNonCurrent() {
        return deferredTaxLiabilitiesNonCurrent;
    }

    public void setDeferredTaxLiabilitiesNonCurrent(double deferredTaxLiabilitiesNonCurrent) {
        this.deferredTaxLiabilitiesNonCurrent = deferredTaxLiabilitiesNonCurrent;
    }

    public int getOtherNonCurrentLiabilities() {
        return otherNonCurrentLiabilities;
    }

    public void setOtherNonCurrentLiabilities(int otherNonCurrentLiabilities) {
        this.otherNonCurrentLiabilities = otherNonCurrentLiabilities;
    }

    public int getTotalNonCurrentLiabilities() {
        return totalNonCurrentLiabilities;
    }

    public void setTotalNonCurrentLiabilities(int totalNonCurrentLiabilities) {
        this.totalNonCurrentLiabilities = totalNonCurrentLiabilities;
    }

    public int getOtherLiabilities() {
        return otherLiabilities;
    }

    public void setOtherLiabilities(int otherLiabilities) {
        this.otherLiabilities = otherLiabilities;
    }

    public int getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(int totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public int getCommonStock() {
        return commonStock;
    }

    public void setCommonStock(int commonStock) {
        this.commonStock = commonStock;
    }

    public int getRetainedEarnings() {
        return retainedEarnings;
    }

    public void setRetainedEarnings(int retainedEarnings) {
        this.retainedEarnings = retainedEarnings;
    }

    public int getAccumulatedOtherComprehensiveIncomeLoss() {
        return accumulatedOtherComprehensiveIncomeLoss;
    }

    public void setAccumulatedOtherComprehensiveIncomeLoss(int accumulatedOtherComprehensiveIncomeLoss) {
        this.accumulatedOtherComprehensiveIncomeLoss = accumulatedOtherComprehensiveIncomeLoss;
    }

    public int getOthertotalStockholdersEquity() {
        return othertotalStockholdersEquity;
    }

    public void setOthertotalStockholdersEquity(int othertotalStockholdersEquity) {
        this.othertotalStockholdersEquity = othertotalStockholdersEquity;
    }

    public int getTotalStockholdersEquity() {
        return totalStockholdersEquity;
    }

    public void setTotalStockholdersEquity(int totalStockholdersEquity) {
        this.totalStockholdersEquity = totalStockholdersEquity;
    }

    public long getTotalLiabilitiesAndStockholdersEquity() {
        return totalLiabilitiesAndStockholdersEquity;
    }

    public void setTotalLiabilitiesAndStockholdersEquity(long totalLiabilitiesAndStockholdersEquity) {
        this.totalLiabilitiesAndStockholdersEquity = totalLiabilitiesAndStockholdersEquity;
    }

    public int getTotalInvestments() {
        return totalInvestments;
    }

    public void setTotalInvestments(int totalInvestments) {
        this.totalInvestments = totalInvestments;
    }

    public long getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(long totalDebt) {
        this.totalDebt = totalDebt;
    }

    public int getNetDebt() {
        return netDebt;
    }

    public void setNetDebt(int netDebt) {
        this.netDebt = netDebt;
    }

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
}
