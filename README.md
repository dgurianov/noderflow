#Noderflow 

Version 0.0.1

###Description
Application with configurable REST API  that simulates flow of activities. 

### Configuration


#####Api requirements

1. Data
- Create a user with all details:  
POST /users with payload
- Create bulk amount of users with details
- Get all users or part of their details
- Get simulation history

2. Flow endpoints
- Start simulation
- Start with time limit
- Start until min/max amount of users went bankrupt 
- Stop simulation

#####Payload
- Create user
```json
{
    "first-name": "John",
    "last-name": "Musterman",
    "contacts": {
      "phone": "+763 4606702",
      "address": {
        "city": "Stuttgart",
        "country": "Peru",
        "street": "Chatham Place",
        "apartment": "45"
      }
    },
    "payment-data":{
       "account-number" : "0123456789",
       "account-balance" : "100.00",
        /*Amount that has to be used in case of top-up the account*/
       "account-auto-top-up-amount" : "100.00", 
       /*How often to load money on customer account*/ 
       "account-auto-top-up-frequency" : "1",
       "account-auto-top-up-time-units" : "hour"
    }
} 
```

- Bulk create users with default\ non default parameters
```json
{
"quantity" : "5",
"start-balance" : "100.00",
/*Amount that has to be used in case of top-up the account*/
"account-auto-top-up-amount" : "100.00", 
/*How often to load money on customer account*/ 
"account-auto-top-up-time-frequency" : "1",
"account-auto-top-up-time-units" : "hour"
}
```

#####Required output 
JSON response with OK 200 HTTP status and payload
```aidl
{
"students": {
    "gradedA" : 10,
    "gradedB" : 15,
    "notGraded" : 1
    }
}
```
###Implementation assumptions
1. Incoming data uses http
2. Mapping is done on ID basis
3. ...

###Compile, run tests and execute
Please use gradle wrapper to compile and run application from command line 

#####Run tests
Use the command below to run tests from console
```aidl
./gradlew --console=plain clean build
```   

#####Run application
Use command below to start the application
```aidl
./gradlew --console=plain bootRun
```

###API Documentation
After application start , there is swagger documentation enabled for this project

1. Swagger2 GUI with documentation http://localhost:8080/swagger-ui.html

2. Swagger2 auto-generated API is available by url http://localhost:8080/v2/api-docs