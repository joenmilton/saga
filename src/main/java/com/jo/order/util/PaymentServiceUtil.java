package com.jo.order.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.order.db.OrderDao;
import com.jo.order.dto.OrderDto;

@Service
public class PaymentServiceUtil {
	
	@Autowired
	private OrderDao orderDao;
	
	public OrderDto processPayment(OrderDto orderDto) {
		//change the status to success
		orderDao.save(orderDto);
		return orderDto;
	}
	
	public OrderDto failOrder(OrderDto orderDto) {
		//change the status to failure, soft delete
		orderDao.delete(orderDto);
		return orderDto;
	}
	
}
