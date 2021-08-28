package com.github.SakuraMatrix.BareMarket.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @GetMapping()
    public Mono<String> test() {
        return Mono.just("test");
    }
}
