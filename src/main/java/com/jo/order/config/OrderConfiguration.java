package com.jo.order.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.PaymentFailedEvent;

/**
 * 
 */
@Configuration
public class OrderConfiguration {
	
	@Bean
	public ExecutorService asyncThreadPool() {
		ExecutorService exe = Executors.newCachedThreadPool();
		return exe;
	}
	
	@Bean
	public BlockingQueue<OrderCreatedEvent> orderCreatedEventQueue(){
		return new LinkedBlockingQueue<>();
	}
	
	@Bean
	public BlockingQueue<PaymentFailedEvent> paymentFailedEventQueue(){
		return new LinkedBlockingQueue<>();
	}
	
}
