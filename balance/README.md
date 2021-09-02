# Balance
A service to manage a user's cash balance.

## Table structure
| id    | balance  |
| ----- | -------- |
| (int) | (double) |

## Endpoints
- GET `/balances`
- PUT `/balances`

## Example requests
- `curl localhost:8080/balances`
- `curl -X PUT -H 'Content-Type: application/json' -d '{ "id": 1, "balance": 1 }' localhost:8080/balances`

## Run Karate tests
```
$ mvn test -Dtest=BalanceRunner
```

## Run application
```
$ mvn spring-boot:run
```