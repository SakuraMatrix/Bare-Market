package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.IncomeStatement;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncomeStatementService {
    public IncomeStatement parse(String jsonString){
        IncomeStatement incomeStatement = new IncomeStatement();
        String toBeSplit = jsonString.substring(1, jsonString.length()-1); //Delete the curly brackets.
        String[] split = toBeSplit.split(",");

        for (int index = 0; index < split.length; index ++){
            if (index == 1){
                incomeStatement.setSymbol(split[index].split("=")[1]);
            }
            if (index == 0){
                incomeStatement.setDate(split[index].split("=")[1]);
            }
            if (index == 6){
                incomeStatement.setRevenue(Long.parseLong(split[index].split("=")[1]));
            }
            if (index == 27){
                incomeStatement.setNetIncome(Double.parseDouble(split[index].split("=")[1]));
            }
            if (index == 29){
                incomeStatement.setEps(Double.parseDouble(split[index].split("=")[1]));
            }
        }

        return incomeStatement;
    }

    public List<IncomeStatement> isListCreation(List<IncomeStatement> isList) {
//        System.out.println("isList size: " + isList.size());
//        System.out.println("isList isEmpty?: " + isList.isEmpty());
//        System.out.println("isList content: " + isList);

        for (int i = 0; i < isList.size(); i++) {
//            System.out.println("API's Response = " + isList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            isList.set(i, this.parse(isList.get(i) + ""));

//            System.out.println("Symbol: " + isList.get(i).getSymbol());
//            System.out.println("Date: " + isList.get(i).getDate());
//            System.out.println("Revenue: " + isList.get(i).getRevenue());
//            System.out.println("NetIncome: " + isList.get(i).getNetIncome());
//            System.out.println("Eps: " + isList.get(i).getEps());
//            System.out.println(" ");
        }
        return isList;
    }
}
