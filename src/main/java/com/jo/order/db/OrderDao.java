package com.jo.order.db;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jo.order.dto.OrderDto;

@Component
public class OrderDao  {
	private static List<OrderDto> list = new ArrayList<>();
	
	private static Logger logger = LoggerFactory.getLogger(OrderDao.class);
	
	public void save(OrderDto orderDto) {
		logger.info("Order data has been saved in DB.");
		list.add(orderDto);
	}
	
	public void delete(OrderDto orderDto) {
		list.remove(orderDto);
	}
}
