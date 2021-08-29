package com.github.SakuraMatrix.BareMarket.analytics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SakuraMatrix.BareMarket.analytics.domain.BalanceSheetStatement;
import com.github.SakuraMatrix.BareMarket.analytics.domain.Pillar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class BalanceSheetStatementService {
    private ObjectMapper objectMapper;
    @Value("${API_KEY}")
    private String API_KEY;
    private WebClient webClient;

    public BalanceSheetStatementService(WebClient webClient){
        this.objectMapper = new ObjectMapper();
        this.webClient = webClient;
    }

//    public Mono<String> bssCheck(String symbol) {
//        return webClient.get()
//                .uri("https://financialmodelingprep.com/api/v3/balance-sheet-statement/{symbol}?limit=1&apikey={API_KEY}", symbol, API_KEY)
//                .retrieve()
//                .bodyToMono(String.class);
//    }

    public Flux<BalanceSheetStatement> bssCheck(String symbol) {
        String str =  webClient.get()
                .uri("https://financialmodelingprep.com/api/v3/balance-sheet-statement/{symbol}?limit=5&apikey={API_KEY}", symbol, API_KEY)
                .retrieve().bodyToMono(String.class).toString();
                //.bodyToMono(String.class).toString();

        System.out.println(str);
        String toBeSplit = str.substring(3, str.length()-3); //Delete square brackets from beginning and end.

        String[] dataSplit = toBeSplit.split("}, \\{"); //Split the 5 Json objects.

        ArrayList<BalanceSheetStatement> bssList = new ArrayList<>();

        for (String s : dataSplit) {
            System.out.println("{" + s.trim() + "}");
            bssList.add(deserialize("{" + s.trim() + "}")); //Use the trim method to handle possible empty spaces, and accommodate the lack of curly braces from the substring & splits.
        }

        return Flux.fromIterable(bssList); //Populate Flux with the contents of bssList
    }


    private BalanceSheetStatement deserialize(String string){
        BalanceSheetStatement balanceSheetStatement;
        try {
            balanceSheetStatement = objectMapper.readValue(string, BalanceSheetStatement.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            balanceSheetStatement = null;
        }
        return balanceSheetStatement;
    }

}
