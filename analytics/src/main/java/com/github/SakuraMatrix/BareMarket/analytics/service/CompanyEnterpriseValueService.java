package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.CompanyEnterpriseValue;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CompanyEnterpriseValueService {

    public CompanyEnterpriseValue parse(String jsonString){
        CompanyEnterpriseValue companyEnterpriseValue = new CompanyEnterpriseValue();
        String toBeSplit = jsonString.substring(1, jsonString.length()-1); //Delete the curly brackets.
        String[] split = toBeSplit.split(",");

        for (int index = 0; index < split.length; index ++){
            if (index == 0){
                companyEnterpriseValue.setSymbol(split[index].split("=")[1]);
            }
            if (index == 1){
                companyEnterpriseValue.setDate(split[index].split("=")[1]);
            }
            if (index == 2){
                companyEnterpriseValue.setStockPrice(Double.parseDouble(split[index].split("=")[1]));
            }
            if (index == 3){
//                System.out.println("Just Checking: " + split[index].split("=")[1]);
                companyEnterpriseValue.setNumberOfShares(Long.parseLong(split[index].split("=")[1]));
            }
            if (index == 4){
                companyEnterpriseValue.setMarketCapitalization(new BigDecimal((split[index].split("=")[1])));
            }
        }

        return companyEnterpriseValue;
    }

    public List<CompanyEnterpriseValue> cevListCreation(List<CompanyEnterpriseValue> cevList){
//        System.out.println("==================================");
//        System.out.println("cevList size: " + cevList.size());
//        System.out.println("cevList isEmpty?: " + cevList.isEmpty());
//        System.out.println("cevList content: " + cevList);
//        System.out.println("==================================");

        for (int i = 0; i < cevList.size(); i++){
//            System.out.println("API's Response = "+cevList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            cevList.set(i, this.parse(cevList.get(i) +""));

//            System.out.println("Symbol: " + cevList.get(i).getSymbol());
//            System.out.println("Date: " + cevList.get(i).getDate());
//            System.out.println("StockPrice: " + cevList.get(i).getStockPrice());
//            System.out.println("NumberOfShares: " + cevList.get(i).getNumberOfShares());
//            System.out.println("MarketCapitalization " + cevList.get(i).getMarketCapitalization());
//            System.out.println(" ");
        }
        return cevList;
    }
}
