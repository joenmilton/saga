package com.jo.order.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderCreatedEventHandler orderEventHandler;
	
	@Autowired
	private OrderServiceUtil orderServiceUtil;
	
	@Autowired
	private OrderServiceMapper orderServiceMapper; 

	
	@Override
	public void processOrder(OrderDto orderDto) {
		logger.info("Processing order {}", orderDto.getOrderId());
		if(Optional.ofNullable(orderDto.getOrderId()).isPresent()) {
			orderDto =  orderServiceUtil.processOrder(orderDto);
			OrderCreatedEvent createdEvent = orderServiceMapper.map(orderDto);
			orderEventHandler.handle(createdEvent);
		}else {
			logger.info("Order service is failed due to ", orderDto.getOrderId());
		}
	}
	
	
	@Override
	public void failOrder(PaymentFailedEvent paymentFailedEvent) {
		OrderDto orderDto =  orderServiceMapper.map(paymentFailedEvent);
		orderServiceUtil.failOrder(orderDto);
	}
}
