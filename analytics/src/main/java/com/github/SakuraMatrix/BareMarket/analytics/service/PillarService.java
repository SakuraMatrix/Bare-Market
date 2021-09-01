package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PillarService {
    private BalanceSheetStatementService balanceSheetStatementService = new BalanceSheetStatementService();
    private CompanyEnterpriseValueService companyEnterpriseValueService = new CompanyEnterpriseValueService();
    private IncomeStatementService incomeStatementService = new IncomeStatementService();
    private CashFlowStatementService cashFlowStatementService = new CashFlowStatementService();
    private QuoteService quoteService = new QuoteService();

    private List<BalanceSheetStatement> bssList;
    private BalanceSheetStatement bss;

    private List<CashFlowStatement> cfsList;
    private CashFlowStatement csf;

    private List<CompanyEnterpriseValue> cevList;
    private CompanyEnterpriseValue cev;

    private List<IncomeStatement> isList;
    private IncomeStatement is;

    private List<Quote> quoteList;
    private Quote quote;

    public PillarService(List<BalanceSheetStatement> bssList, List<CashFlowStatement> cfsList, List<CompanyEnterpriseValue> cevList, List<IncomeStatement> isList, List<Quote> quoteList){
        this.bssList = balanceSheetStatementService.bssListCreation(bssList);
        this.cfsList = cashFlowStatementService.cfsListCreation(cfsList);
        this.cevList = companyEnterpriseValueService.cevListCreation(cevList);
        this.isList = incomeStatementService.isListCreation(isList);
        this.quoteList = quoteService.quoteListCreation(quoteList);
    }

    public String allPillars(){
        String result1 = this.pillar1(this.isList, this.cevList, this.quoteList);
        String result2 = this.pillar2(this.cfsList, this.bssList.get(0));
        String result3 = this.pillar3(this.isList);
        String result4 = this.pillar4(this.isList);

        return result1 + "\n \n" + result2 + "\n \n" + result3 + "\n \n" + result4;
    }

    public String pillar1(List<IncomeStatement> isList, List<CompanyEnterpriseValue> cevList, List<Quote> quoteList){
        String listedInfo = "";
        String info = "[" + "Most Recent <-> " + "Price: " + quoteList.get(0).getPrice() + " / " + "EPS: "+ quoteList.get(0).getEps() + " = " + "PE: " + quoteList.get(0).getPe() + "] \n";
        if (cevList.size() == 1){ //Checks for cevList being at least greater than 1 to proceed, or else stops analyzing the company due to being too young.
            return "Company too young to analyze using pillar 1";
        }

        ArrayList<Double> sumOfPe = new ArrayList<Double>();
        double averageOfPe = 0;

        for (int i=0; i < isList.size()-1;i++){
            CompanyEnterpriseValue cevElement = cevList.get(i);
            System.out.println("WEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE made it at least once");
            double stockPrice = cevElement.getStockPrice();

            double eps = isList.get(i).getEps();
            if (eps < 0 && quoteList.get(0).getPe() == -11.11){
                return "Pillar One[5YR PE] DANGER: Company has negative earning per share present.";
            }
            sumOfPe.add( stockPrice / eps ); //This will be doing the calculations for StockPrice / eps ; and store it into an arrayList.
            System.out.println("pe being stored: " + sumOfPe.get(i));

            listedInfo += "[" + isList.get(i).getDate() + " <--> " + "Price: " + cevList.get(i).getStockPrice() + " / " + "EPS: " + isList.get(i).getEps() + " = " + "PE:"+(cevList.get(i).getStockPrice()/isList.get(i).getEps() + "] \n");
        }

        info += listedInfo;

        sumOfPe.add(quoteList.get(0).getPe());

        for (int i=0; i < sumOfPe.size();i++){
            averageOfPe += sumOfPe.get(i);
        }

        averageOfPe /= isList.size();

        System.out.print("Average of current PE along with the past " + (isList.size()-1) + " PEs: " + averageOfPe);

        return "Pillar One[5YR PE] calculated: " + averageOfPe + " =< 22.5 \n" + info;
    }

    public String pillar2(List<CashFlowStatement> cfsList, BalanceSheetStatement bss){
        BigDecimal fcfAverage = BigDecimal.valueOf(0);
        BigDecimal result;
        BigDecimal divisor = BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity());

        for (int i = 0; i < cfsList.size(); i++){
//            System.out.println("Symbol: " + cfsList.get(i).getSymbol());
//            System.out.println("Date: " + cfsList.get(i).getDate());
//            System.out.println("FreeCashFlow: " + cfsList.get(i).getFreeCashFlow());
            fcfAverage = fcfAverage.add(BigDecimal.valueOf(cfsList.get(i).getFreeCashFlow()));
        }

        System.out.println("Sum FreeCashFlow: " + fcfAverage) ;

        result = fcfAverage.divide(BigDecimal.valueOf(cfsList.size()));
        System.out.println("Average FreeCashFlow: " + result);

        result = result.divide(divisor, 2, RoundingMode.HALF_UP);
        System.out.println("TotalLiabilitiesAndStockholdersEquity: " + divisor);
        System.out.println(fcfAverage + " / " + divisor + " = " + result);

//        result = fcfAverage.divide(BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity()));

//        System.out.println("Average FreeCashFlow: " + fcfAverage.divide(BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity()))) ;
//        System.out.println("Average FreeCashFlow: " +  BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity()).divide(fcfAverage));

        return "Pillar Two[5YRE ROIC] calculated: " + result + " => 0.9%";
    }

    public String pillar3(List<IncomeStatement> isList) {
        //HashMap<String,Double> yearlyDifference = new HashMap<String, Double>();
        String result = "";
        String resultA = "";
        BigDecimal calculation;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        BigDecimal totalCalculation = BigDecimal.valueOf(0);

        ArrayList<DecimalFormat> termCalculations = new ArrayList<>();

        for (int i = 0; i < isList.size(); i++){
            if(isList.size() - i == 1){ //This is to break out of loop due to other operations in this block looks an index ahead.
                resultA+= "[" + isList.get(i).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i).getRevenue())) + "]" + "\n";
                break;
            }
            calculation = BigDecimal.valueOf(isList.get(i).getRevenue()).subtract(BigDecimal.valueOf(isList.get(i+1).getRevenue()));
            //yearlyDifference.put("Term "+i,calculation);
            totalCalculation = totalCalculation.add(calculation);

            resultA+= "[" + isList.get(i).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i).getRevenue())) + "]" + "\n";

            result+= "Term "+ (i+1) + ": "+ formatter.format(calculation) + " <--> [" +isList.get(i).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i).getRevenue()))
                    + " <-- " + isList.get(i+1).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i+1).getRevenue())) +"]" + "\n";
        }

        return "Pillar Three[Revenue Growth] calculated: \n" + resultA + "\n" + result + "\n" + "Sum of all terms: " + formatter.format(totalCalculation);
    }

    public String pillar4(List<IncomeStatement> isList){
        //HashMap<String,Double> yearlyDifference = new HashMap<String, Double>();
        String result = "";
        String resultA = "";
        BigDecimal calculation;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        BigDecimal totalCalculation = BigDecimal.valueOf(0);

        ArrayList<DecimalFormat> termCalculations = new ArrayList<>();

        for (int i = 0; i < isList.size(); i++){
            if(isList.size() - i == 1){ //This is to break out of loop due to other operations in this block looks an index ahead.
                resultA+= "[" + isList.get(i).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i).getNetIncome())) + "]" + "\n";
                break;
            }
            calculation = BigDecimal.valueOf(isList.get(i).getNetIncome()).subtract(BigDecimal.valueOf(isList.get(i+1).getNetIncome()));
            //yearlyDifference.put("Term "+i,calculation);
            totalCalculation = totalCalculation.add(calculation);

            resultA+= "[" + isList.get(i).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i).getNetIncome())) + "]" + "\n";

            result+= "Term "+ (i+1) + ": "+ formatter.format(calculation) + " <--> [" +isList.get(i).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i).getNetIncome()))
                    + " <-- " + isList.get(i+1).getDate() + " : " + formatter.format(BigDecimal.valueOf(isList.get(i+1).getNetIncome())) +"]" + "\n";
        }

        return "Pillar Four[Net Income Growth] calculated: \n" + resultA + "\n" + result + "\n" + "Sum of all terms: " + formatter.format(totalCalculation);
    }












    public List<BalanceSheetStatement> getBssList() {
        return bssList;
    }

    public void setBssList(List<BalanceSheetStatement> bssList) {
        this.bssList = bssList;
    }

    public BalanceSheetStatement getBss() {
        return bss;
    }

    public void setBss(BalanceSheetStatement bss) {
        this.bss = bss;
    }

    public List<CashFlowStatement> getCfsList() {
        return cfsList;
    }

    public void setCfsList(List<CashFlowStatement> cfsList) {
        this.cfsList = cfsList;
    }

    public CashFlowStatement getCsf() {
        return csf;
    }

    public void setCsf(CashFlowStatement csf) {
        this.csf = csf;
    }

    public List<CompanyEnterpriseValue> getCevList() {
        return cevList;
    }

    public void setCevList(List<CompanyEnterpriseValue> cevList) {
        this.cevList = cevList;
    }

    public CompanyEnterpriseValue getCev() {
        return cev;
    }

    public void setCev(CompanyEnterpriseValue cev) {
        this.cev = cev;
    }

    public List<IncomeStatement> getIsList() {
        return isList;
    }

    public void setIsList(List<IncomeStatement> isList) {
        this.isList = isList;
    }

    public IncomeStatement getIs() {
        return is;
    }

    public void setIs(IncomeStatement is) {
        this.is = is;
    }

    public List<Quote> getQuoteList() {

        return quoteList;
    }

    public void setQuoteList(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
