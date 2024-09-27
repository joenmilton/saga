package com.jo.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;
import com.jo.order.handler.OrderCreatedEventHandler;
import com.jo.order.service.OrderService;
import com.jo.order.service.OrderServiceMapper;
import com.jo.order.util.OrderServiceUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderCreatedEventHandler orderEventHandler;
	
	@Autowired
	private OrderServiceUtil orderServiceUtil;
	
	@Autowired
	private OrderServiceMapper orderServiceMapper; 

	
	@Override
	public void processOrder(OrderDto orderDto) {
		orderDto =  orderServiceUtil.processOrder(orderDto);
		OrderCreatedEvent createdEvent = orderServiceMapper.map(orderDto);
		orderEventHandler.orderCreatedEvent(createdEvent);
	}
	
	
	@Override
	public void failOrder(PaymentFailedEvent paymentFailedEvent) {
		OrderDto orderDto =  orderServiceMapper.map(paymentFailedEvent);
		orderServiceUtil.failOrder(orderDto);
	}
}
