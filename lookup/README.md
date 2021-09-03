# Lookup
A service to look up a company's stock quote.

## Features
A user will be able to:
- search for a company's stock quote

## Endpoints
- GET `/search/{symbol}`

## Example requests
- `curl localhost:8080/search/GOOGL`

## Run Karate tests
```
$ mvn test -Dtest=StockLookupRunner
```

## Run application
```
$ mvn spring-boot:run
```