package com.github.SakuraMatrix.BareMarket.usergateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/watchlists/**").uri("lb://watchlist-service"))
            .route(r -> r.path("/balances/**").uri("lb://balance-service"))
            .route(r -> r.path("/search/**").uri("lb://lookup-service"))
            .route(r -> r.path("/stocks/**").uri("lb://portfolio-service"))
            .build();
    }
}
