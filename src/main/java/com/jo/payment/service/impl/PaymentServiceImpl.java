package com.jo.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;
import com.jo.order.handler.OrderCreatedEventHandler;
import com.jo.order.service.OrderService;
import com.jo.order.service.OrderServiceMapper;
import com.jo.order.util.OrderServiceUtil;
import com.jo.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentCreatedEventHandler orderEventHandler;
	
	@Autowired
	private OrderServiceUtil orderServiceUtil;
	
	@Autowired
	private OrderServiceMapper orderServiceMapper; 

	
	@Override
	public void processPayment(OrderCreatedEvent orderDto) {
		
		
	}
}
