package com.jo.payment.service;

import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;

@Component
public class PaymentServiceMapper {
	
	
	public OrderDto map(OrderCreatedEvent paymentFailedEvent) {
		OrderDto orderDto = new OrderDto();
		return orderDto;
	}
}
