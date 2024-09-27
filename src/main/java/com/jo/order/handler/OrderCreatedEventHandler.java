package com.jo.order.handler;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;

@Component
public class OrderCreatedEventHandler {
	
	private static Logger logger = LoggerFactory.getLogger(OrderCreatedEventHandler.class);
	
	@Autowired
	private BlockingQueue<OrderCreatedEvent> orderCreatedEventQueue;
	
	public void orderCreatedEvent(OrderCreatedEvent orderCreatedEvent) {
		orderCreatedEventQueue.add(orderCreatedEvent);
		logger.info("Order created event has been sent to Payment service.");
	}
	
	
	//Event listener, incase of exception in payment service This service will be invoked
	public void consumeFailurePayment() {
		while(true) {
			//Thread.sleep(1000);
			//PaymentFailedEvent paymentFailedEvent = paymentFailedEventQueue.take();
			//Rollback the changes for order
			//orderService.failOrder(paymentFailedEvent);
		}
	}
}
