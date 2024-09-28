package com.jo.order.dto;

public class OrderDto {
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "Order Id :" + orderId;
	}
	
}
