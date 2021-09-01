package com.github.SakuraMatrix.BareMarket.analytics.controller;

import com.github.SakuraMatrix.BareMarket.analytics.domain.*;
import com.github.SakuraMatrix.BareMarket.analytics.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/pillars")
public class MainController {
    private BalanceSheetStatementService balanceSheetStatementService = new BalanceSheetStatementService();
    private CompanyEnterpriseValueService companyEnterpriseValueService = new CompanyEnterpriseValueService();
    private IncomeStatementService incomeStatementService = new IncomeStatementService();
    private CashFlowStatementService cashFlowStatementService = new CashFlowStatementService();
    private PillarService pillarService;

    @Value("${API_KEY}")
    private String API_KEY;

    private static final String MAIN_PAGE = "main";
    private static final String JSON_BSS_URL = "https://financialmodelingprep.com/api/v3/balance-sheet-statement/";
    private static final String JSON_CEV_URL = "https://financialmodelingprep.com/api/v3/enterprise-values/";
    private static final String JSON_IS_URL = "https://financialmodelingprep.com/api/v3/income-statement/";
    private static final String JSON_CFS_URL = "https://financialmodelingprep.com/api/v3/cash-flow-statement/";
    private static final String JSON_QUOTE_URL = "https://financialmodelingprep.com/api/v3/quote/";

//    @GetMapping("/bss/{symbol}")
//    @ResponseBody
//    public String index3(@PathVariable String symbol) {return "Should be done";}

    @Autowired
    private ParsingService parsingService;

    @GetMapping("/bss/{symbol}")
    @ResponseBody
//    public String main(final Model model) {
    public String index(@PathVariable String symbol) {
        String newURL = JSON_BSS_URL+ symbol + "?limit=5&apikey="+API_KEY;
        List<BalanceSheetStatement> bssList = (List<BalanceSheetStatement>) parsingService.parse(newURL); // the given json returns a list of BSS.
        balanceSheetStatementService.bssListCreation(bssList);

        return "Balance Sheet Statement created";
    }

    @GetMapping("/cev/{symbol}")
    @ResponseBody
//    public String main(final Model model) {
    public String index2(@PathVariable String symbol) {
        String newURL = JSON_CEV_URL+ symbol + "?limit=5&apikey="+API_KEY;
        List<CompanyEnterpriseValue> cevList = (List<CompanyEnterpriseValue>) parsingService.parse(newURL); // the given json returns a list of BSS.
        companyEnterpriseValueService.cevListCreation(cevList);

        return "Company Enterprise Value created";
    }

    @GetMapping("/pillar-all/{symbol}")
    @ResponseBody
    public String allPillars(@PathVariable String symbol){
        String newURL = JSON_BSS_URL+symbol + "?limit=1&apikey="+API_KEY; //Used for 1st API call.
        String newURL2 = JSON_CFS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for 2nd API call.
        String newURL3 = JSON_CEV_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for 3rd API call.
        String newURL4 = JSON_IS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for 4th API call.
        String newURL5 = JSON_QUOTE_URL+ symbol + "?limit=1&apikey="+API_KEY; //Used for 5th API call.

        List<BalanceSheetStatement> bssList = (List<BalanceSheetStatement>) parsingService.parse(newURL); // returns a json list of CFS.
        List<CashFlowStatement> cfsList = (List<CashFlowStatement>) parsingService.parse(newURL2); // returns a json list of CFS.
        List<CompanyEnterpriseValue> cevList = (List<CompanyEnterpriseValue>) parsingService.parse(newURL3); // returns a json list of CEV.
        List<IncomeStatement> isList = (List<IncomeStatement>) parsingService.parse(newURL4); // returns a json list of IS.
        List<Quote> quoteList = (List<Quote>) parsingService.parse(newURL5);
        pillarService = new PillarService(bssList,cfsList,cevList,isList,quoteList);

        return pillarService.allPillars();
    }

//    @GetMapping("/pillar-1/{symbol}")
//    @ResponseBody
////    public String main(final Model model) {
//    public String pillarOne(@PathVariable String symbol) {
//        String newURL = JSON_IS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for Pillar1's API call one.
//        String newURL2 = JSON_CEV_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for Pillar2's API call two.
//
//        List<CompanyEnterpriseValue> cevList = (List<CompanyEnterpriseValue>) parsingService.parse(newURL2); // returns a json list of CEV.
//        cevList = companyEnterpriseValueService.cevListCreation(cevList); //Properly parse the json to get only wanted values for each element in the list of the json object.
//        List<IncomeStatement> isList = (List<IncomeStatement>) parsingService.parse(newURL); // returns a json list of IS.
//
//        double result = incomeStatementService.pillar1(incomeStatementService.isListCreation(isList),cevList); // IncomeStatementService.java will have the calculations of the first pillar in its method.
//        if (result == -11.11){
//            return "Company too young to analyze using pillar 1";
//        }
//        return "Pillar One[5YR PE] calculated: " + result + " =< 22.5";
//    }
//    @GetMapping("/pillar-2/{symbol}")
//    @ResponseBody
////    public String main(final Model model) {
//    public String pillarTwo(@PathVariable String symbol) {
//        String newURL = JSON_CFS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for Pillar2's 1st API call.
//        String newURL2 = JSON_BSS_URL+symbol + "?limit=1&apikey="+API_KEY; //Used for Pillar2's 2nd API call.
//
//        List<BalanceSheetStatement> bssList = (List<BalanceSheetStatement>) parsingService.parse(newURL2);
//        BalanceSheetStatement bss = balanceSheetStatementService.bssListCreation(bssList).get(0);
//
//        List<CashFlowStatement> cfsList = (List<CashFlowStatement>) parsingService.parse(newURL); // returns a json list of CFS.
//
//        BigDecimal result = cashFlowStatementService.pillar2(cashFlowStatementService.cfsListCreation(cfsList),bss);
//
//
//
//        return "Pillar Two[5YRE ROIC] calculated: " + result + " => 0.9%";
//    }
//
//    @GetMapping("/pillar-3/{symbol}")
//    @ResponseBody
////    public String main(final Model model) {
//    public String pillarThree(@PathVariable String symbol) {
//        String newURL = JSON_IS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for Pillar1's API call one.
//
//        List<IncomeStatement> isList = (List<IncomeStatement>) parsingService.parse(newURL); // returns a json list of IS.
//
//        String result = incomeStatementService.pillar3(incomeStatementService.isListCreation(isList)); // IncomeStatementService.java will have the calculations of the first pillar in its method.
//        return "Pillar Three[5YR Revenue Growth]: \n" + result;
//    }
}
