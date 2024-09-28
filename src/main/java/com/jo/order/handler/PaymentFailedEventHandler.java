package com.jo.order.handler;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jo.order.dto.PaymentFailedEvent;
import com.jo.order.service.OrderService;

import jakarta.annotation.PostConstruct;

@Component
public class PaymentFailedEventHandler implements EventHandler{
	
	private static Logger logger = LoggerFactory.getLogger(PaymentFailedEventHandler.class);
	
	@Autowired
	private BlockingQueue<PaymentFailedEvent> paymentFailedEventQueue;
	
	@Autowired
	private OrderService orderService;
	
	public void handle() throws InterruptedException {
		logger.info("Configured PaymentFailedEventHandler");
		while(true) {
			PaymentFailedEvent paymentFailedEvent = paymentFailedEventQueue.take();
			orderService.failOrder(paymentFailedEvent);
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
