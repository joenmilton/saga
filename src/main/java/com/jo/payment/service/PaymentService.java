package com.jo.payment.service;

import com.jo.order.dto.OrderCreatedEvent;

public interface PaymentService {
	public void processPayment(OrderCreatedEvent orderDto);
}
