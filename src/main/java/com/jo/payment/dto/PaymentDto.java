package com.jo.payment.dto;

import com.jo.order.dto.OrderDto;

public class PaymentDto extends OrderDto {
	private int paymentId;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	@Override
	public String toString() {
		return "Payment Id :" + paymentId;
	}
}
