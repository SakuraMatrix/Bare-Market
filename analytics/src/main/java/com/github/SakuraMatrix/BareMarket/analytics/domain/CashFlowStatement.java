package com.github.SakuraMatrix.BareMarket.analytics.domain;

public class CashFlowStatement {

    private String date; //************ 1
    private String symbol; //************ 2
    private String reportedCurrency;
    private String fillingDate;
    private String acceptedDate;

    private String period;
    private String netIncome;
    private int depreciationAndAmortization;
    private int deferredIncomeTax;
    private int stockBasedCompensation;

    private int changeInWorkingCapital;
    private int accountsReceivables;
    private int inventory;
    private int accountsPayables;
    private int otherWorkingCapital;

    private int otherNonCashItems;
    private int netCashProvidedByOperatingActivities;
    private int investmentsInPropertyPlantAndEquipment;
    private int acquisitionsNet;
    private int purchasesOfInvestments;

    private int salesMaturitiesOfInvestments;
    private int otherInvestingActivites;
    private int netCashUsedForInvestingActivites;
    private int debtRepayment;
    private int commonStockIssued;

    private int commonStockRepurchased;
    private int dividendsPaid;
    private int otherFinancingActivites;
    private int netCashUsedProvidedByFinancingActivities;
    private int effectOfForexChangesOnCash;

    private int netChangeInCash;
    private int cashAtEndOfPeriod;
    private int cashAtBeginningOfPeriod;
    private int operatingCashFlow;
    private int capitalExpenditure;

    private long freeCashFlow; //************ 3
    private String link;
    private String finalLink;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReportedCurrency() {
        return reportedCurrency;
    }

    public void setReportedCurrency(String reportedCurrency) {
        this.reportedCurrency = reportedCurrency;
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

    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    public int getDepreciationAndAmortization() {
        return depreciationAndAmortization;
    }

    public void setDepreciationAndAmortization(int depreciationAndAmortization) {
        this.depreciationAndAmortization = depreciationAndAmortization;
    }

    public int getDeferredIncomeTax() {
        return deferredIncomeTax;
    }

    public void setDeferredIncomeTax(int deferredIncomeTax) {
        this.deferredIncomeTax = deferredIncomeTax;
    }

    public int getStockBasedCompensation() {
        return stockBasedCompensation;
    }

    public void setStockBasedCompensation(int stockBasedCompensation) {
        this.stockBasedCompensation = stockBasedCompensation;
    }

    public int getChangeInWorkingCapital() {
        return changeInWorkingCapital;
    }

    public void setChangeInWorkingCapital(int changeInWorkingCapital) {
        this.changeInWorkingCapital = changeInWorkingCapital;
    }

    public int getAccountsReceivables() {
        return accountsReceivables;
    }

    public void setAccountsReceivables(int accountsReceivables) {
        this.accountsReceivables = accountsReceivables;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getAccountsPayables() {
        return accountsPayables;
    }

    public void setAccountsPayables(int accountsPayables) {
        this.accountsPayables = accountsPayables;
    }

    public int getOtherWorkingCapital() {
        return otherWorkingCapital;
    }

    public void setOtherWorkingCapital(int otherWorkingCapital) {
        this.otherWorkingCapital = otherWorkingCapital;
    }

    public int getOtherNonCashItems() {
        return otherNonCashItems;
    }

    public void setOtherNonCashItems(int otherNonCashItems) {
        this.otherNonCashItems = otherNonCashItems;
    }

    public int getNetCashProvidedByOperatingActivities() {
        return netCashProvidedByOperatingActivities;
    }

    public void setNetCashProvidedByOperatingActivities(int netCashProvidedByOperatingActivities) {
        this.netCashProvidedByOperatingActivities = netCashProvidedByOperatingActivities;
    }

    public int getInvestmentsInPropertyPlantAndEquipment() {
        return investmentsInPropertyPlantAndEquipment;
    }

    public void setInvestmentsInPropertyPlantAndEquipment(int investmentsInPropertyPlantAndEquipment) {
        this.investmentsInPropertyPlantAndEquipment = investmentsInPropertyPlantAndEquipment;
    }

    public int getAcquisitionsNet() {
        return acquisitionsNet;
    }

    public void setAcquisitionsNet(int acquisitionsNet) {
        this.acquisitionsNet = acquisitionsNet;
    }

    public int getPurchasesOfInvestments() {
        return purchasesOfInvestments;
    }

    public void setPurchasesOfInvestments(int purchasesOfInvestments) {
        this.purchasesOfInvestments = purchasesOfInvestments;
    }

    public int getSalesMaturitiesOfInvestments() {
        return salesMaturitiesOfInvestments;
    }

    public void setSalesMaturitiesOfInvestments(int salesMaturitiesOfInvestments) {
        this.salesMaturitiesOfInvestments = salesMaturitiesOfInvestments;
    }

    public int getOtherInvestingActivites() {
        return otherInvestingActivites;
    }

    public void setOtherInvestingActivites(int otherInvestingActivites) {
        this.otherInvestingActivites = otherInvestingActivites;
    }

    public int getNetCashUsedForInvestingActivites() {
        return netCashUsedForInvestingActivites;
    }

    public void setNetCashUsedForInvestingActivites(int netCashUsedForInvestingActivites) {
        this.netCashUsedForInvestingActivites = netCashUsedForInvestingActivites;
    }

    public int getDebtRepayment() {
        return debtRepayment;
    }

    public void setDebtRepayment(int debtRepayment) {
        this.debtRepayment = debtRepayment;
    }

    public int getCommonStockIssued() {
        return commonStockIssued;
    }

    public void setCommonStockIssued(int commonStockIssued) {
        this.commonStockIssued = commonStockIssued;
    }

    public int getCommonStockRepurchased() {
        return commonStockRepurchased;
    }

    public void setCommonStockRepurchased(int commonStockRepurchased) {
        this.commonStockRepurchased = commonStockRepurchased;
    }

    public int getDividendsPaid() {
        return dividendsPaid;
    }

    public void setDividendsPaid(int dividendsPaid) {
        this.dividendsPaid = dividendsPaid;
    }

    public int getOtherFinancingActivites() {
        return otherFinancingActivites;
    }

    public void setOtherFinancingActivites(int otherFinancingActivites) {
        this.otherFinancingActivites = otherFinancingActivites;
    }

    public int getNetCashUsedProvidedByFinancingActivities() {
        return netCashUsedProvidedByFinancingActivities;
    }

    public void setNetCashUsedProvidedByFinancingActivities(int netCashUsedProvidedByFinancingActivities) {
        this.netCashUsedProvidedByFinancingActivities = netCashUsedProvidedByFinancingActivities;
    }

    public int getEffectOfForexChangesOnCash() {
        return effectOfForexChangesOnCash;
    }

    public void setEffectOfForexChangesOnCash(int effectOfForexChangesOnCash) {
        this.effectOfForexChangesOnCash = effectOfForexChangesOnCash;
    }

    public int getNetChangeInCash() {
        return netChangeInCash;
    }

    public void setNetChangeInCash(int netChangeInCash) {
        this.netChangeInCash = netChangeInCash;
    }

    public int getCashAtEndOfPeriod() {
        return cashAtEndOfPeriod;
    }

    public void setCashAtEndOfPeriod(int cashAtEndOfPeriod) {
        this.cashAtEndOfPeriod = cashAtEndOfPeriod;
    }

    public int getCashAtBeginningOfPeriod() {
        return cashAtBeginningOfPeriod;
    }

    public void setCashAtBeginningOfPeriod(int cashAtBeginningOfPeriod) {
        this.cashAtBeginningOfPeriod = cashAtBeginningOfPeriod;
    }

    public int getOperatingCashFlow() {
        return operatingCashFlow;
    }

    public void setOperatingCashFlow(int operatingCashFlow) {
        this.operatingCashFlow = operatingCashFlow;
    }

    public int getCapitalExpenditure() {
        return capitalExpenditure;
    }

    public void setCapitalExpenditure(int capitalExpenditure) {
        this.capitalExpenditure = capitalExpenditure;
    }

    public long getFreeCashFlow() {
        return freeCashFlow;
    }

    public void setFreeCashFlow(long freeCashFlow) {
        this.freeCashFlow = freeCashFlow;
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
