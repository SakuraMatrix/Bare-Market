package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.CashFlowStatement;
import org.springframework.stereotype.Service;
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
//            System.out.println("API's Response = "+ cfsList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            cfsList.set(i, this.parse(cfsList.get(i) +""));

//            System.out.println("Symbol: " + cfsList.get(i).getSymbol());
//            System.out.println("Date: " + cfsList.get(i).getDate());
//            System.out.println("FreeCashFlow: " + cfsList.get(i).getFreeCashFlow());
//            System.out.println(" ");
        }
        return cfsList;
    }
}
