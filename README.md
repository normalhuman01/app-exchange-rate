# app-exchange-rate
```python
docker-compose build
```

```python
docker-compose up
```

Paso 1: Generar token -> [POST] http://localhost:8080/auth/login

```bash
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "user",
    "password": "password"
}'

```
Paso 2: Cotizar tipo de cambio -> [POST] http://localhost:8080/exchange-rate
```bash
curl --location 'http://localhost:8080/exchange-rate' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjk3NTA3NTE0LCJleHAiOjE2OTc1MTExMTR9.gOdxCgGi7jD7FkKIoCQ4LQMTmIF0dH-nsVobD3GEF-ge-JWQqXgRxAzZH29Bq5Sy' \
--data '{
    "amount": 50.00,
    "currencySource": "USD",
    "currencyTarget": "PEN"
}'
```

Paso 3: Actualizar tipo de cambio -> [PUT] http://localhost:8080/exchange-rate
```bash
curl --location --request PUT 'http://localhost:8080/exchange-rate' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjk3NDg4NDIxLCJleHAiOjE2OTc0OTIwMjF9.roSmQyUe3haoICXUoKQxyD3Sw3gQcBybmgTfYO8kxCbOxcbhycARCXt_hS28g0UK' \
--data '{
    "exchangeRateAmount": 3.86,
    "currencySource": "USD",
    "currencyTarget": "PEN"
}'
```
