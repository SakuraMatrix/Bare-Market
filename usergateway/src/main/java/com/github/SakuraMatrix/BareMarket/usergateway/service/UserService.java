package com.github.SakuraMatrix.BareMarket.usergateway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {
    private WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }
}
