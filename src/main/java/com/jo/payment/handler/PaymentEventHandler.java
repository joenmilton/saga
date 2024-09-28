package com.jo.payment.handler;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.payment.service.PaymentService;

import jakarta.annotation.PostConstruct;

@Component
public class PaymentEventHandler {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentEventHandler.class);

	@Autowired
	private PaymentService paymentService; 
	
	@Autowired
	private BlockingQueue<OrderCreatedEvent> orderCreatedEventQueue;
	
	public void handle() throws InterruptedException {
		logger.info("PaymentEventHandler is configured.");
		while(true) {
			OrderCreatedEvent orderCreatedEvent = orderCreatedEventQueue.take();
			logger.info("Payment Service received the event {}", orderCreatedEvent.getOrderId());
			paymentService.processPayment(orderCreatedEvent);
		}
	}
	
	@PostConstruct
	private void init() {
		new Thread(()->{
			try {
				this.handle();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();;
	}

}
