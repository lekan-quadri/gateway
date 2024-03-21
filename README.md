# Spring Boot Project

This is a simple Java / Maven / Spring Boot (version 3.2.3) application that was built based on requirement provided. 

## How to Run 
Clone repository and run. Java 17 or higher is required.

# Understanding of Task
H2 Database is used and the Core Banking API isn't intgrated. All calls to api/transactions will return successful
This API will be the middleware between third party vendors. The API recieves the request, then calls the core banking api, stores the response and also return response to vendor.

# Expectaions

Once application is cloned and run, http://localhost:8080/swagger-ui/index.html provides access to the Swagger UI

Three(3) endpoints are provided:

1. Post Transaction
url: /api/transactions 
method: POST
payload: {
    "retailTransactionId":"txn00000001",
    "account":"100000001",
    "amount":"1000.00"
}


2. Get Transaction Status
url: /{transactionId}



3. Webhook Notification 


