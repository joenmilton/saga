package com.jo.payment.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jo.order.dto.CommonAsyncResponse;
import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.service.OrderService;
import com.jo.order.util.EventProcessEnum;

@Component
public class PaymentEventHandler {

	@Autowired
	private BlockingQueue<OrderCreatedEvent> orderCreatedEventQueue;
	
	

	
	public ResponseEntity<CommonAsyncResponse> order(@RequestBody OrderDto orderDto) throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			OrderCreatedEvent paymentFailedEvent = orderCreatedEventQueue.take();
			
		}
	}

}
