# **Saga-Orchestrator**

Added logic of saga pattern, writing testcases, documentation, code cleaning not completed(pending thsings can be discussed in a session ).

## **Technologies Used**
List the main technologies and frameworks used in the project.
- Java 8
- Spring Boot 2.7.x
- Maven
- JUnit 5 for testing

## **Test cases ran though postman**
1) Order Service Failure(if order id is null, then the order transaction will be failed)
url -> localhost:8080/order
payload > {}


2) Payment Service Success(if order id is 1, then the order transaction will be failed)
- url -> localhost:8080/order
- payload > {"orderId":1}

3) Payment Service Failure(if order id is 0, then the order transaction will be failed)
- url -> localhost:8080/order
- payload > {"orderId":0}


