# Watchlist
A service to hold a list of favorite stocks to watch.

## Table structure
| id    | symbol  |
| ----- | ------- |
| (int) | (text) |

## Endpoints
- GET `/watchlists`
- POST `/watchlists`
- DELETE `/watchlists/{symbol}`

## Example requests
- `curl localhost:8080/watchlists`
- `curl -X POST -H 'Content-Type: application/json' -d '{ "watchlistKey": { "id": 1, "symbol": "GOOGL" } }' localhost:8080/watchlists`
- `curl -X DELETE localhost:8080/watchlists/GOOGL`

## Run Karate tests
```
$ mvn test -Dtest=WatchlistRunner
```

## Run application
```
$ mvn spring-boot:run
```