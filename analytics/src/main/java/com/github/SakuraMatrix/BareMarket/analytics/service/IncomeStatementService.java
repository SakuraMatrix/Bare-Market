package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SakuraMatrix.BareMarket.analytics.domain.CompanyEnterpriseValue;
import com.github.SakuraMatrix.BareMarket.analytics.domain.IncomeStatement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.lang.Integer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
            if (index == 26){
                incomeStatement.setNetIncome(Long.parseLong(split[index].split("=")[1]));
            }
            if (index == 29){
                incomeStatement.setEps(Double.parseDouble(split[index].split("=")[1]));
            }
        }

        return incomeStatement;
    }

    public List<IncomeStatement> isListCreation(List<IncomeStatement> isList) {
        for (int i = 0; i < isList.size(); i++) {
            System.out.println("API's Response = " + isList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            isList.set(i, this.parse(isList.get(i) + ""));

            System.out.println("Symbol: " + isList.get(i).getSymbol());
            System.out.println("Date: " + isList.get(i).getDate());
            System.out.println("Revenue: " + isList.get(i).getRevenue());
            System.out.println("NetIncome: " + isList.get(i).getNetIncome());
            System.out.println("Eps: " + isList.get(i).getEps());
            System.out.println(" ");
        }
        return isList;
    }

    public double pillar1(List<IncomeStatement> isList, List<CompanyEnterpriseValue> cevList){

        ArrayList<Double> sumOfPe = new ArrayList<Double>();
        double averageOfPe = 0;

        for (int i=0; i < isList.size();i++){
            CompanyEnterpriseValue cevElement = cevList.get(i);
            double stockPrice = cevElement.getStockPrice();
            double eps = isList.get(i).getEps();
            sumOfPe.add( stockPrice / eps ); //This will be doing the calculations for StockPrice / eps ; and store it into an arrayList.
            System.out.println("pe being stored: " + sumOfPe.get(i));
        }

        for (int i=0; i < sumOfPe.size();i++){
            averageOfPe += sumOfPe.get(i);
        }

        averageOfPe /= isList.size();

        System.out.print("Average of past 5 PEs: " + averageOfPe);

        return averageOfPe;
    }

    public String pillar3(List<IncomeStatement> isList) {
        //HashMap<String,Double> yearlyDifference = new HashMap<String, Double>();
        String result = "";
        BigDecimal calculation;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        BigDecimal totalCalculation = BigDecimal.valueOf(0);

        ArrayList<DecimalFormat> termCalculations = new ArrayList<>();

        for (int i = 0; i < isList.size(); i++){
            if(isList.size() - i == 1){
                break;
            }
            calculation = BigDecimal.valueOf(isList.get(i).getRevenue()).subtract(BigDecimal.valueOf(isList.get(i+1).getRevenue()));
            //yearlyDifference.put("Term "+i,calculation);
            totalCalculation = totalCalculation.add(calculation);

            result+= "Term "+ (i+1) + ": "+ formatter.format(calculation) + "\n";
        }


        return result + "\n" + "Sum of all terms: " + formatter.format(totalCalculation);
    }
}
