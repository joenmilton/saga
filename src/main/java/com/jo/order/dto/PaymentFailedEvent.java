package com.jo.order.dto;

import com.jo.order.util.EventProcessEnum;

public class PaymentFailedEvent {
	private OrderDto orderDto;

	private EventProcessEnum status;
	
	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	public EventProcessEnum getStatus() {
		return status;
	}

	public void setStatus(EventProcessEnum status) {
		this.status = status;
	}
	
	
}
