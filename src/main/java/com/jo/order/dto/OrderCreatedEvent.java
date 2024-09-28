package com.jo.order.dto;

import com.jo.order.util.EventProcessEnum;

public class OrderCreatedEvent {
	private Integer orderId;

	private EventProcessEnum status;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public EventProcessEnum getStatus() {
		return status;
	}

	public void setStatus(EventProcessEnum status) {
		this.status = status;
	}
}
