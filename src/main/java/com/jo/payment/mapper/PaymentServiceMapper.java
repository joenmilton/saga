package com.jo.payment.mapper;

import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderCreatedEvent;
import com.jo.order.dto.OrderDto;
import com.jo.order.dto.PaymentFailedEvent;
import com.jo.order.util.EventProcessEnum;
import com.jo.payment.dto.PaymentDto;

@Component
public class PaymentServiceMapper {
	
	
	public PaymentDto map(OrderCreatedEvent orderCreatedEvent) {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setOrderId(orderCreatedEvent.getOrderDto().getOrderId());
		return paymentDto;
	}
	
	public PaymentFailedEvent map(PaymentDto paymentDto) {
		PaymentFailedEvent paymentFailed = new PaymentFailedEvent();
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(paymentDto.getOrderId());
		paymentFailed.setOrderDto(orderDto);
		paymentFailed.setStatus(EventProcessEnum.PAYMENT_FAILED);
		return paymentFailed;
	}
}


