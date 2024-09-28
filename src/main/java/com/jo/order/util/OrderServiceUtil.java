package com.jo.order.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.order.db.OrderDao;
import com.jo.order.dto.OrderDto;

@Service
public class OrderServiceUtil {
	
	private static Logger logger = LoggerFactory.getLogger(OrderServiceUtil.class);
	
	@Autowired
	private OrderDao orderDao;
	
	public OrderDto processOrder(OrderDto orderDto) {
		logger.info("Saving Order {}", orderDto.getOrderId());
		orderDao.save(orderDto);
		return orderDto;
	}
	
	public OrderDto failOrder(OrderDto orderDto) {
		logger.info("Rollback Order {}", orderDto.getOrderId());
		orderDao.delete(orderDto);
		return orderDto;
	}
	
}
