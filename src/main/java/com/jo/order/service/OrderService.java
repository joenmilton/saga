package com.jo.order.service;

import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;

public interface OrderService {
	public void processOrder(OrderDto orderDto);
	public void failOrder(PaymentFailedEvent paymentFailedEvent);
}
