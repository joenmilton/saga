package com.jo.payment.service.impl;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.PaymentFailedEvent;
import com.jo.payment.dto.PaymentDto;
import com.jo.payment.mapper.PaymentServiceMapper;
import com.jo.payment.service.PaymentService;
import com.jo.payment.util.PaymentServiceUtil;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private PaymentServiceUtil paymentServiceUtil;
	
	@Autowired
	private PaymentServiceMapper paymentServiceMapper; 

	@Autowired
	private BlockingQueue<PaymentFailedEvent> paymentFailedEventQueue;

	
	@Override
	public void processPayment(OrderCreatedEvent orderCreatedEvent) {
		PaymentDto paymentDto =  paymentServiceMapper.map(orderCreatedEvent);
		logger.info("Payment Service is invoked {}", orderCreatedEvent.getOrderDto().getOrderId());
		try {
			paymentServiceUtil.processPayment(paymentDto);
		}catch (Exception e) {
			PaymentFailedEvent paymentFailedEvent = paymentServiceMapper.map(paymentDto);
			paymentFailedEventQueue.add(paymentFailedEvent);
		}
		
	}
}
