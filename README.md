#Noderflow 

Version 1.0.0

###Description
Application with configurable REST API  that simulates flow of transactions. 

#Configuration

Configuration file : application.properties in home folder location

#####Configurable properties and their defaults

Amount of threads used to bulk create users
```
noderflow.bulk.order.queue.running.threads=4
```

Kafka topic name to publish transaction events
```
noderflow.publish.kafka.topic.name=noderflow_transactions
```

Kafka broker connection string
``` 
noderflow.publish.kafka.brokers=192.168.99.100:9092
```

Celling for random generated amount that will be used in transaction.
Real transaction value will be 100 times less , i.e. 3456 will became 34.56, so 5000 limit means 50,00 max transaction amount.
```
noderflow.transaction.amount.max=5000
``` 

Interval between publishing transaction.
```
noderflow.transaction.publish.interval.millisec=500
```

#Available calls

#####Start the flow of transactions
Request type : GET

URL: {HOST}:{PORT}/v1/api/flow/start

Response :
```json
{
  "response": "Transaction flow started"
}
```

#####Stop the flow of transactions
Request type : GET

URL: {HOST}:{PORT}/v1/api/flow/stop

Response :
```json
{
  "response": "Transaction flow stopped"
}
```

#####Get all users 
Request type : GET

URL: {HOST}:{PORT}/v1/api/users

Response :
```json
[
  {
    "first-name": " Aaron",
    "last-name": "Adams",
    "contacts": {
      "phone": "+094 8768497",
      "address": {
        "city": "Pittsgburgh",
        "country": "Iran",
        "street": "Connaught Square",
        "apartment": "21"
      }
    },
    "payment-data": {
      "account-number": "000000000001",
      "account-balance": "33619.00",
      "account-auto-top-up-amount": "226.00",
      "account-auto-top-up-frequency": 7,
      "account-auto-top-up-time-units": "MINUTES"
    }
  }]
```

#####Get all balances 
Request type : GET

URL: {HOST}:{PORT}/v1/api/balances

Response :
```json
[
  {
    "account-number": "000000000026",
    "account-balance": "454.00"
  },
  {
    "account-number": "000000000014",
    "account-balance": "488.00"
  },
  {
    "account-number": "000000000021",
    "account-balance": "247.00"
  }
]
```

#####Bulk create users
Request type : POST

URL:  {HOST}:{PORT}/v1/api/bulk-create/users

Body payload: 
```json
{
  "quantity" : 10
}
```

Response:

```json
{
  "response": "created"
}
```

#####Create one specific user
Request type : POST

URL: {HOST}:{PORT}/v1/api/users

Body payload:
```json
{
    "id": "d1903aa7-027a-4000-8716-477f9058a60b",
    "first-name": "MrSmith",
    "last-name": "Smith",
    "contacts": {
      "id": "c1903aa7-027a-4000-8716-477f9058a60b",
      "phone": "+49 162 00000",
      "socialNetworkProfile": "Faceboak1",
      "linkedinProfile": "http://linkedin profile",
      "address": {
        "id": "b1903aa7-027a-4000-8716-477f9058a60b",
        "city": "Kyiw",
        "country": "UA",
        "street": "Lunacharskogo",
        "apartment": "1"
      }
    }
  }
```

#API Documentation
After application start , there is swagger documentation enabled for this project

1. Swagger2 GUI with documentation http://localhost:8080/swagger-ui.html

2. Swagger2 auto-generated API is available by url http://localhost:8080/v2/api-docs