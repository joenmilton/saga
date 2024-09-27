package com.jo.payment.service;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;

public interface PaymentService {
	public void processPayment(OrderCreatedEvent orderDto);
}
