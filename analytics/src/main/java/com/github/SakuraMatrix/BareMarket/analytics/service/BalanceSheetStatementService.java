package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.BalanceSheetStatement;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BalanceSheetStatementService {
    public BalanceSheetStatement parse(String jsonString){
        BalanceSheetStatement balanceSheetStatement = new BalanceSheetStatement();
        String toBeSplit = jsonString.substring(1, jsonString.length()-1); //Delete the curly brackets.
        String[] split = toBeSplit.split(",");

        for (int index = 0; index < split.length; index ++){
            if (index == 0){
                balanceSheetStatement.setDate(split[index].split("=")[1]);
            }
            if (index == 1){
                balanceSheetStatement.setSymbol(split[index].split("=")[1]);
            }
            if (index == 29){
                balanceSheetStatement.setLongTermDebt(Long.parseLong(split[index].split("=")[1]));
            }
            if (index == 41){
                balanceSheetStatement.setTotalLiabilitiesAndStockholdersEquity(Long.parseLong(split[index].split("=")[1]));
            }
            if (index == 43){
                balanceSheetStatement.setTotalDebt(Long.parseLong(split[index].split("=")[1]));
            }
        }

        return balanceSheetStatement;
    }

    public List<BalanceSheetStatement> bssListCreation(List<BalanceSheetStatement> bssList){
        for (int i = 0; i < bssList.size(); i++){
//            System.out.println("API's Response = "+bssList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            bssList.set(i, this.parse(bssList.get(i) +""));

//            System.out.println("Symbol: " + bssList.get(i).getSymbol());
//            System.out.println("Date: " + bssList.get(i).getDate());
//            System.out.println("TotalLongTermDebt: " + bssList.get(i).getLongTermDebt());
//            System.out.println("TotalLiabilitiesAndStockholdersEquity: " + bssList.get(i).getTotalLiabilitiesAndStockholdersEquity());
//            System.out.println("TotalDebt: " + bssList.get(i).getTotalDebt());
//            System.out.println(" ");
        }
        return bssList;
    }
}
