# User Gateway
This service is the 'entry point', or gateway the user will access to make requests to other services and consists of the Spring RouteLocator to redirect requests to the corresponding contact points.

Additionally, this service comprises the additional handling of the logic between a user's cash balance and conducting trades.

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