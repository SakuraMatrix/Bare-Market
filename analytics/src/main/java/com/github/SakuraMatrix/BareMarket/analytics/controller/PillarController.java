package com.github.SakuraMatrix.BareMarket.analytics.controller;

import com.github.SakuraMatrix.BareMarket.analytics.domain.*;
import com.github.SakuraMatrix.BareMarket.analytics.service.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController //Ientifies this as a controller file and will handle routing.
@RequestMapping(value = "/pillars")
public class PillarController {
    private PillarService pillarService;
    private BalanceSheetStatementService balanceSheetStatementService ;
    private CompanyEnterpriseValueService companyEnterpriseValueService;
    private IncomeStatementService incomeStatementService;
    private CashFlowStatementService cashFlowStatementService;

    public PillarController(PillarService pillarService, BalanceSheetStatementService balanceSheetStatementService) {
        this.pillarService = pillarService;
        this.balanceSheetStatementService = balanceSheetStatementService;
    }


    @GetMapping("/{symbol}")
    public Mono<Pillar> index2(@PathVariable String symbol) throws IOException {return pillarService.pillarOne(symbol);}
//    public String index2(@RequestParam String param) throws IOException {System.out.print(param); return pillarService.pillarOne(param);}

    @GetMapping("/bss/{symbol}")
    @ResponseBody
    public Flux<BalanceSheetStatement> index3(@PathVariable String symbol) {return balanceSheetStatementService.bssCheck(symbol);}

    @GetMapping("/cfs/{symbol}")
    public Mono<String> index4(@PathVariable String symbol) throws IOException {return cashFlowStatementService.cfsCheck(symbol);}

    @GetMapping("/cve/{symbol}")
    public Mono<String> index5(@PathVariable String symbol) throws IOException {return companyEnterpriseValueService.cevCheck(symbol);}

    @GetMapping("/is/{symbol}")
    public Mono<String> index6(@PathVariable String symbol) throws IOException {return incomeStatementService.isCheck(symbol);}
}
