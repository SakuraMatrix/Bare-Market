package com.github.SakuraMatrix.BareMarket.usergateway.controller;

import com.github.SakuraMatrix.BareMarket.usergateway.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Mono<String> test() {
        return Mono.just("test");
    }
}
