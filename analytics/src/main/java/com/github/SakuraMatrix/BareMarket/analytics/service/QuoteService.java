package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.github.SakuraMatrix.BareMarket.analytics.domain.CashFlowStatement;
import com.github.SakuraMatrix.BareMarket.analytics.domain.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    public Quote parse(String jsonString){
        Quote quote = new Quote();
        String toBeSplit = jsonString.substring(1, jsonString.length()-1); //Delete the curly brackets.
        String[] split = toBeSplit.split(",");

        for (int index = 0; index < split.length; index ++){
            if (index == 0){
                quote.setSymbol(split[index].split("=")[1]);
            }
            if (index == 2){
                quote.setPrice(Double.parseDouble(split[index].split("=")[1]));
            }
            if (index == 17){
                quote.setEps(Double.parseDouble(split[index].split("=")[1]));
            }
            if (index == 18){
                System.out.println("BUG FLAG: " + split[index].split("=")[1] );
                if (split[index].split("=")[1].contains("null")){
                    quote.setPe(-11.11);
                }
                else {quote.setPe(Double.parseDouble(split[index].split("=")[1]));}
            }
        }

        return quote;
    }

    public List<Quote> quoteListCreation(List<Quote> quoteList) {
        for (int i = 0; i < quoteList.size(); i++){
            System.out.println("API's Response = "+ quoteList.get(i));
//            System.out.println("This is concatenation = " + bssList.get(i));
            quoteList.set(i, this.parse(quoteList.get(i) +""));

            System.out.println("Symbol: " + quoteList.get(i).getSymbol());
            System.out.println("Price: " + quoteList.get(i).getPrice());
            System.out.println("EPS: " + quoteList.get(i).getEps());
            System.out.println("PE " + quoteList.get(i).getPe());
            System.out.println(" ");
        }
        return quoteList;

    }

        }
