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

import javax.xml.catalog.Catalog;
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

    private static final String JSON_BSS_URL = "https://financialmodelingprep.com/api/v3/balance-sheet-statement/";
    private static final String JSON_CEV_URL = "https://financialmodelingprep.com/api/v3/enterprise-values/";
    private static final String JSON_IS_URL = "https://financialmodelingprep.com/api/v3/income-statement/";
    private static final String JSON_CFS_URL = "https://financialmodelingprep.com/api/v3/cash-flow-statement/";
//    private static final String JSON_QUOTE_URL = "https://financialmodelingprep.com/api/v3/quote/";

    @Autowired
    private ParsingService parsingService;

    @GetMapping("/pillar-all/{symbol}")
    @ResponseBody
    public String allPillars(@PathVariable String symbol){
        String newURL = JSON_BSS_URL+symbol + "?limit=1&apikey="+API_KEY; //Used for 1st API call.
        String newURL2 = JSON_CFS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for 2nd API call.
        String newURL3 = JSON_CEV_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for 3rd API call.
        String newURL4 = JSON_IS_URL+ symbol + "?limit=5&apikey="+API_KEY; //Used for 4th API call.
//        String newURL5 = JSON_QUOTE_URL+ symbol + "?limit=1&apikey="+API_KEY; //Used for 5th API call.

        List<BalanceSheetStatement> bssList = (List<BalanceSheetStatement>) parsingService.parse(newURL); // returns a json list of CFS.
        List<CashFlowStatement> cfsList = (List<CashFlowStatement>) parsingService.parse(newURL2); // returns a json list of CFS.
        List<CompanyEnterpriseValue> cevList = (List<CompanyEnterpriseValue>) parsingService.parse(newURL3); // returns a json list of CEV.
        List<IncomeStatement> isList = (List<IncomeStatement>) parsingService.parse(newURL4); // returns a json list of IS.
//        List<Quote> quoteList = (List<Quote>) parsingService.parse(newURL5);
        pillarService = new PillarService(bssList,cfsList,cevList,isList);

        return pillarService.allPillars();
    }
}
