package com.jo.order.service;

import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;

@Component
public class OrderServiceMapper {
	
	public OrderCreatedEvent map(OrderDto orderDto) {
		OrderCreatedEvent createdEvent = new OrderCreatedEvent();
		return createdEvent;
	}
	
	
	public OrderDto map(PaymentFailedEvent paymentFailedEvent) {
		OrderDto orderDto = new OrderDto();
		return orderDto;
	}
}
