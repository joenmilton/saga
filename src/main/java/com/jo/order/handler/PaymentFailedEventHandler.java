package com.jo.order.handler;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;
import com.jo.order.util.OrderServiceUtil;

@Component
public class PaymentFailedEventHandler {
	
	@Autowired
	private BlockingQueue<PaymentFailedEvent> paymentFailedEventQueue;
	
	@Autowired
	private OrderServiceUtil orderServiceUtil;
	
	//Event listener, incase of exception in payment service This service will be invoked
	public void consumeFailurePayment() {
		while(true) {
			//Thread.sleep(1000);
			//PaymentFailedEvent paymentFailedEvent = paymentFailedEventQueue.take();
			//Rollback the changes for order
			//orderServiceUtil.failOrder(paymentFailedEvent);
		}
	}
}
