# Bare Market
![Bare Market](https://raw.githubusercontent.com/SakuraMatrix/p2-Bare-Market/main/images/SPY%20February%202020.png)

Bare Market is a trading platform where a user can buy and sell stocks to build one's portfolio.

At the moment, Bare Market is limited to only stocks (no options trading, etc.), and only at the current market price (no stop limits, etc.).

## Features
Bare Market comprises of several distributed services:
- Analytics service
    - A user can:
        - analyze a given stock to determine whether they should research and/or invest in said stock
- Balances service
    - A user can:
        - retrieve their cash balance
        - adjust their balance
- Lookup service
    - A user can:
        - retrieve a company's stock quote
- Portfolio service
    - A user can:
        - retrieve all stocks currently owned
        - add a stock to their portfolio
        - remove a stock from their portfolio
- User gateway service
    - A user can:
        - access all services from a single endpoint
        - retrieve a live feed of their watchlist with current company quotes
        - purchase a stock and update their balance accordingly
        - sell a stock and update their balance accordingly
- Watchlist service
    - A user can:
        - retrieve their watchlist
        - add a stock to their watchlist
        - remove a stock from their watchlist

## Discovery service
Given the distributed nature of the services, a discovery service such as Spring Cloud Netflix Eureka is used to locate each individual service.

![Discovery Service Graph](https://raw.githubusercontent.com/SakuraMatrix/p2-Bare-Market/main/images/discovery.png)

A user will be able to access each service from a single entry point (the gateway) routing requests to each service accordingly.

## Technologies
- Java
- Maven
- Apache Cassandra / Amazon Keyspaces
- Spring Boot
- Spring WebFlux
- Spring WebClient
- Spring Data Reactive for Apache Cassandra
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka
- Karate

## Contributors
[Tam](https://github.com/tamhpn/)

[Josue](https://github.com/elwinJ/)

[Gaby](https://github.com/agabriela-amezcua/)
