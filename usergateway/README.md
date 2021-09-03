# User Gateway
This service is the 'entry point', or gateway the user will access to make requests to other services and consists of the Spring RouteLocator to redirect requests to the corresponding contact points.

Additionally, this service comprises the additional handling of the logic between a user's cash balance and conducting trades.

## Features
A user will be able to:
- access all other services comprising the Bare Market application
- retrieve a live feed of their watchlist with up to date company quotes
- purchase a stock, given their account has enough money to cover the trade
- sell a stock and increase their balance accordingly

## Endpoints
- GET `/summary`
- POST `/holdings`
- DELETE `/holdings/{symbol}/{timestamp}`

## Example requests
- `curl localhost:8080/summary`
- `curl -X POST -H 'Content-Type: application/json' -d '{ "symbol": "GOOGL" }' localhost:8080/holdings`
- `curl -X DELETE localhost:8080/holdings/GOOGL/1`

## Run Karate tests
```
$ mvn test -Dtest=GatewayRunner
```

## Run application
```
$ mvn spring-boot:run
```