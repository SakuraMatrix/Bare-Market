package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.BalanceSheetStatement;
import com.github.SakuraMatrix.BareMarket.analytics.domain.CashFlowStatement;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class CashFlowStatementService {
    public CashFlowStatement parse(String jsonString){
        CashFlowStatement cashFlowStatement = new CashFlowStatement();
        String toBeSplit = jsonString.substring(1, jsonString.length()-1); //Delete the curly brackets.
        String[] split = toBeSplit.split(",");

        for (int index = 0; index < split.length; index ++){
            if (index == 0){
                cashFlowStatement.setDate(split[index].split("=")[1]);
            }
            if (index == 1){
                cashFlowStatement.setSymbol(split[index].split("=")[1]);
            }
            if (index == 33){
                cashFlowStatement.setFreeCashFlow(Long.parseLong(split[index].split("=")[1]));
            }
        }

        return cashFlowStatement;
    }

    public List<CashFlowStatement> cfsListCreation(List<CashFlowStatement> cfsList) {
        for (int i = 0; i < cfsList.size(); i++){
            System.out.println("API's Response = "+ cfsList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            cfsList.set(i, this.parse(cfsList.get(i) +""));

            System.out.println("Symbol: " + cfsList.get(i).getSymbol());
            System.out.println("Date: " + cfsList.get(i).getDate());
            System.out.println("FreeCashFlow: " + cfsList.get(i).getFreeCashFlow());
            System.out.println(" ");
        }
        return cfsList;

    }

//    public BigDecimal pillar2(  List<CashFlowStatement> cfsList, BalanceSheetStatement bss){
//        BigDecimal fcfAverage = BigDecimal.valueOf(0);
//        BigDecimal result;
//        BigDecimal divisor = BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity());
//
//        for (int i = 0; i < cfsList.size(); i++){
////            System.out.println("Symbol: " + cfsList.get(i).getSymbol());
////            System.out.println("Date: " + cfsList.get(i).getDate());
////            System.out.println("FreeCashFlow: " + cfsList.get(i).getFreeCashFlow());
//            fcfAverage = fcfAverage.add(BigDecimal.valueOf(cfsList.get(i).getFreeCashFlow()));
//        }
//
//        System.out.println("Sum FreeCashFlow: " + fcfAverage) ;
//
//        result = fcfAverage.divide(BigDecimal.valueOf(cfsList.size()));
//        System.out.println("Average FreeCashFlow: " + result);
//
//        result = result.divide(divisor, 2, RoundingMode.HALF_UP);
//        System.out.println("TotalLiabilitiesAndStockholdersEquity: " + divisor);
//        System.out.println(fcfAverage + " / " + divisor + " = " + result);
//
////        result = fcfAverage.divide(BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity()));
//
////        System.out.println("Average FreeCashFlow: " + fcfAverage.divide(BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity()))) ;
////        System.out.println("Average FreeCashFlow: " +  BigDecimal.valueOf(bss.getTotalLiabilitiesAndStockholdersEquity()).divide(fcfAverage));
//
//        return result;
//    }

}
