package com.github.SakuraMatrix.BareMarket.analytics.domain;

public class IncomeStatement {

    private String date; //******************* 1
    private String symbol; //******************* 2
    private String reportedCurrency;
    private String fillingDate;
    private String acceptedDate;

    private String period;
    private long revenue; //******************* 3
    private int costOfRevenue;
    private int grossProfit;
    private double grossProfitRatio;

    private int researchAndDevelopmentExpenses;
    private int generalAndAdministrativeExpenses;
    private double sellingAndMarketingExpenses;
    private int otherExpenses;
    private int operatingExpenses;

    private int costAndExpenses;
    private int interestExpense;
    private int depreciationAndAmortization;
    private int ebitda;
    private double ebitdaratio;

    private int operatingIncome;
    private double operatingIncomeRatio;
    private int totalOtherIncomeExpensesNet;
    private int incomeBeforeTax;
    private double incomeBeforeTaxRatio;

    private int incomeTaxExpense;
    private long netIncome; //******************* 4
    private double netIncomeRatio;
    private double eps; //******************* 5
    private double epsdiluted;

    private int weightedAverageShsOut;
    private int weightedAverageShsOutDil;
    private String link;
    private String finalLink;

    public String getReportedCurrency() {
        return reportedCurrency;
    }

    public void setReportedCurrency(String reportedCurrency) {
        this.reportedCurrency = reportedCurrency;
    }

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

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getCostOfRevenue() {
        return costOfRevenue;
    }

    public void setCostOfRevenue(int costOfRevenue) {
        this.costOfRevenue = costOfRevenue;
    }

    public int getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(int grossProfit) {
        this.grossProfit = grossProfit;
    }

    public double getGrossProfitRatio() {
        return grossProfitRatio;
    }

    public void setGrossProfitRatio(double grossProfitRatio) {
        this.grossProfitRatio = grossProfitRatio;
    }

    public int getResearchAndDevelopmentExpenses() {
        return researchAndDevelopmentExpenses;
    }

    public void setResearchAndDevelopmentExpenses(int researchAndDevelopmentExpenses) {
        this.researchAndDevelopmentExpenses = researchAndDevelopmentExpenses;
    }

    public int getGeneralAndAdministrativeExpenses() {
        return generalAndAdministrativeExpenses;
    }

    public void setGeneralAndAdministrativeExpenses(int generalAndAdministrativeExpenses) {
        this.generalAndAdministrativeExpenses = generalAndAdministrativeExpenses;
    }

    public double getSellingAndMarketingExpenses() {
        return sellingAndMarketingExpenses;
    }

    public void setSellingAndMarketingExpenses(double sellingAndMarketingExpenses) {
        this.sellingAndMarketingExpenses = sellingAndMarketingExpenses;
    }

    public int getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(int otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public int getOperatingExpenses() {
        return operatingExpenses;
    }

    public void setOperatingExpenses(int operatingExpenses) {
        this.operatingExpenses = operatingExpenses;
    }

    public int getCostAndExpenses() {
        return costAndExpenses;
    }

    public void setCostAndExpenses(int costAndExpenses) {
        this.costAndExpenses = costAndExpenses;
    }

    public int getInterestExpense() {
        return interestExpense;
    }

    public void setInterestExpense(int interestExpense) {
        this.interestExpense = interestExpense;
    }

    public int getDepreciationAndAmortization() {
        return depreciationAndAmortization;
    }

    public void setDepreciationAndAmortization(int depreciationAndAmortization) {
        this.depreciationAndAmortization = depreciationAndAmortization;
    }

    public int getEbitda() {
        return ebitda;
    }

    public void setEbitda(int ebitda) {
        this.ebitda = ebitda;
    }

    public double getEbitdaratio() {
        return ebitdaratio;
    }

    public void setEbitdaratio(double ebitdaratio) {
        this.ebitdaratio = ebitdaratio;
    }

    public int getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(int operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public double getOperatingIncomeRatio() {
        return operatingIncomeRatio;
    }

    public void setOperatingIncomeRatio(double operatingIncomeRatio) {
        this.operatingIncomeRatio = operatingIncomeRatio;
    }

    public int getTotalOtherIncomeExpensesNet() {
        return totalOtherIncomeExpensesNet;
    }

    public void setTotalOtherIncomeExpensesNet(int totalOtherIncomeExpensesNet) {
        this.totalOtherIncomeExpensesNet = totalOtherIncomeExpensesNet;
    }

    public int getIncomeBeforeTax() {
        return incomeBeforeTax;
    }

    public void setIncomeBeforeTax(int incomeBeforeTax) {
        this.incomeBeforeTax = incomeBeforeTax;
    }

    public double getIncomeBeforeTaxRatio() {
        return incomeBeforeTaxRatio;
    }

    public void setIncomeBeforeTaxRatio(double incomeBeforeTaxRatio) {
        this.incomeBeforeTaxRatio = incomeBeforeTaxRatio;
    }

    public int getIncomeTaxExpense() {
        return incomeTaxExpense;
    }

    public void setIncomeTaxExpense(int incomeTaxExpense) {
        this.incomeTaxExpense = incomeTaxExpense;
    }

    public long getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(long netIncome) {
        this.netIncome = netIncome;
    }

    public double getNetIncomeRatio() {
        return netIncomeRatio;
    }

    public void setNetIncomeRatio(double netIncomeRatio) {
        this.netIncomeRatio = netIncomeRatio;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {this.eps = eps;}

    public double getEpsdiluted() {
        return epsdiluted;
    }

    public void setEpsdiluted(double epsdiluted) {
        this.epsdiluted = epsdiluted;
    }

    public int getWeightedAverageShsOut() {
        return weightedAverageShsOut;
    }

    public void setWeightedAverageShsOut(int weightedAverageShsOut) {
        this.weightedAverageShsOut = weightedAverageShsOut;
    }

    public int getWeightedAverageShsOutDil() {
        return weightedAverageShsOutDil;
    }

    public void setWeightedAverageShsOutDil(int weightedAverageShsOutDil) {
        this.weightedAverageShsOutDil = weightedAverageShsOutDil;
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
