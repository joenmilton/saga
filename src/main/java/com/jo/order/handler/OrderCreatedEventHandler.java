package com.jo.order.handler;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;

@Component
public class OrderCreatedEventHandler implements EventHandler{
	
	private static Logger logger = LoggerFactory.getLogger(OrderCreatedEventHandler.class);
	
	@Autowired
	private BlockingQueue<OrderCreatedEvent> orderCreatedEventQueue;
	
	public void handle(OrderCreatedEvent orderCreatedEvent) {
		logger.info("Order is created {}", orderCreatedEvent.getOrderId());
		orderCreatedEventQueue.add(orderCreatedEvent);
		logger.info("Order is created and payment service {}", orderCreatedEvent.getOrderId());
	}
}
