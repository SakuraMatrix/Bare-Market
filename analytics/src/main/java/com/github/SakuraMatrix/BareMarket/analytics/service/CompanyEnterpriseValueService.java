package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SakuraMatrix.BareMarket.analytics.domain.BalanceSheetStatement;
import com.github.SakuraMatrix.BareMarket.analytics.domain.CompanyEnterpriseValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
                companyEnterpriseValue.setNumberOfShares(Long.parseLong(split[index].split("=")[1]));
            }
            if (index == 4){
                companyEnterpriseValue.setMarketCapitalization(new BigDecimal((split[index].split("=")[1])));
            }
        }

        return companyEnterpriseValue;
    }

    public List<CompanyEnterpriseValue> cevListCreation(List<CompanyEnterpriseValue> cevList){
        for (int i = 0; i < cevList.size(); i++){
            System.out.println("API's Response = "+cevList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            cevList.set(i, this.parse(cevList.get(i) +""));

            System.out.println("Symbol: " + cevList.get(i).getSymbol());
            System.out.println("Date: " + cevList.get(i).getDate());
            System.out.println("StockPrice: " + cevList.get(i).getStockPrice());
            System.out.println("NumberOfShares: " + cevList.get(i).getNumberOfShares());
            System.out.println("MarketCapitalization " + cevList.get(i).getMarketCapitalization());
            System.out.println(" ");
        }
        return cevList;
    }

    public BigDecimal pillar1(List<CompanyEnterpriseValue> cevList) {
        BigDecimal marketCapitalizationAverage = new BigDecimal(0);

        ArrayList<BigDecimal> Yearly = new ArrayList<BigDecimal>();

        for(CompanyEnterpriseValue element : cevList) {
            marketCapitalizationAverage = marketCapitalizationAverage.add(element.getMarketCapitalization());
            Yearly.add(marketCapitalizationAverage);
        }

        for(int i = 0; i < cevList.size(); i++) {

            System.out.println("Date: " + cevList.get(i).getDate());
            System.out.println("MarketCapitalization: " + cevList.get(i).getMarketCapitalization());
            System.out.println(" " );
        }

        System.out.println("5 Years sum of MarketCapitalization: " + marketCapitalizationAverage);
        marketCapitalizationAverage = marketCapitalizationAverage.divide(new BigDecimal(cevList.size()));
        System.out.println("MarketCapitalizationAverage: " + marketCapitalizationAverage);


        return marketCapitalizationAverage;
    }
}
