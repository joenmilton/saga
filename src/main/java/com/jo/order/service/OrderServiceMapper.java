package com.jo.order.service;

import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;
import com.jo.order.util.EventProcessEnum;

@Component
public class OrderServiceMapper {
	
	public OrderCreatedEvent map(OrderDto orderDto) {
		OrderCreatedEvent createdEvent = new OrderCreatedEvent();
		createdEvent.setOrderDto(orderDto);
		createdEvent.setStatus(EventProcessEnum.ORDER_CREATED);
		return createdEvent;
	}
	
	
	public OrderDto map(PaymentFailedEvent paymentFailedEvent) {
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(paymentFailedEvent.getOrderDto().getOrderId());
		return orderDto;
	}
}
