# **Saga-Orchestrator**

Added logic of saga pattern, writing testcases, documentation, code cleaning not completed(pending thsings can be discussed in a session ).

## **Technologies Used**
List the main technologies and frameworks used in the project.
- Java 8
- Spring Boot 2.7.x
- Maven
- JUnit 5 for testing

## **Test cases ran though postman**
1) Order Service Failure(if order id is null, then the order transaction fail)
- url -> localhost:8080/order
- payload > {}
- logs > 
2024-09-29T11:51:14.784+05:30  INFO 18036 --- [order-service] [nio-8080-exec-9] c.jo.order.controller.OrderController    : Processing order null
2024-09-29T11:51:14.785+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] c.j.order.service.impl.OrderServiceImpl  : Processing order null
2024-09-29T11:51:14.785+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] c.j.order.service.impl.OrderServiceImpl  : Order service is failed due to 


2) Payment Service Success(if order id is 1, then the order and payment transaction be completed)
- url -> localhost:8080/order
- payload > {"orderId":1}
- logs > 
2024-09-29T11:45:51.250+05:30  INFO 18036 --- [order-service] [pool-1-thread-1] c.j.order.service.impl.OrderServiceImpl  : Processing order 1
2024-09-29T11:45:51.251+05:30  INFO 18036 --- [order-service] [pool-1-thread-1] com.jo.order.util.OrderServiceUtil       : Saving Order 1
2024-09-29T11:45:51.251+05:30  INFO 18036 --- [order-service] [pool-1-thread-1] com.jo.order.db.OrderDao                 : Order data has been saved in DB 1
2024-09-29T11:45:51.252+05:30  INFO 18036 --- [order-service] [pool-1-thread-1] c.j.o.handler.OrderCreatedEventHandler   : Order is created 1
2024-09-29T11:45:51.252+05:30  INFO 18036 --- [order-service] [pool-1-thread-1] c.j.o.handler.OrderCreatedEventHandler   : Order is created and payment service 1
2024-09-29T11:45:51.252+05:30  INFO 18036 --- [order-service] [       Thread-2] c.j.payment.handler.PaymentEventHandler  : Payment Service received the event 1
2024-09-29T11:45:51.253+05:30  INFO 18036 --- [order-service] [       Thread-2] c.j.p.service.impl.PaymentServiceImpl    : Payment Service is invoked 1
2024-09-29T11:45:51.253+05:30  INFO 18036 --- [order-service] [       Thread-2] com.jo.payment.db.PaymentDao             : Order data has been saved in DB.
2024-09-29T11:45:51.253+05:30  INFO 18036 --- [order-service] [       Thread-2] com.jo.payment.util.PaymentServiceUtil   : Payment has been saved in DB 1


3) Payment Service Failure(if order id is 0, then the order transaction will be completed and rollback due to payment failure)
- url -> localhost:8080/order
- payload > {"orderId":0}
- logs > 
2024-09-29T11:50:49.018+05:30  INFO 18036 --- [order-service] [nio-8080-exec-3] c.jo.order.controller.OrderController    : Processing order 0
2024-09-29T11:50:49.019+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] c.j.order.service.impl.OrderServiceImpl  : Processing order 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] com.jo.order.util.OrderServiceUtil       : Saving Order 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] com.jo.order.db.OrderDao                 : Order data has been saved in DB 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] c.j.o.handler.OrderCreatedEventHandler   : Order is created 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [pool-1-thread-2] c.j.o.handler.OrderCreatedEventHandler   : Order is created and payment service 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [       Thread-2] c.j.payment.handler.PaymentEventHandler  : Payment Service received the event 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [       Thread-2] c.j.p.service.impl.PaymentServiceImpl    : Payment Service is invoked 0
2024-09-29T11:50:49.020+05:30  INFO 18036 --- [order-service] [       Thread-2] com.jo.payment.util.PaymentServiceUtil   : Payment Failed 0
2024-09-29T11:50:49.021+05:30  INFO 18036 --- [order-service] [       Thread-1] com.jo.order.util.OrderServiceUtil       : Rollback Order 0



