# Portfolio
A service to manage a user's portfolio by looking at stocks it has, adding stocks to it and selling stocks.

## Table structure
| name   | price    |   id  | timestamp | symbol   |
| ------ | -------- | ----- | --------- | -------- |
| (text) | (double) | (int) | (long)    | (text) |

## Endpoints
- GET `/stocks`
- POST `/stocks`
- DELETE `/stocks/{symbol}/{timestamp}`

## Example requests
- `curl localhost:8080/stocks`
- `curl -X POST -H "Content-Type: application/json" localhost:8080/stocks -d '{"stockKey":{"id": 1, "symbol": "GOOGL", "timestamp": 1630557189}, "name": "Alphabet Inc.", "price": 2904.31}'`
- `curl -X DELETE localhost:8080/stocks/GOOGL/1630557189`

## Run application

run main method Application.java
