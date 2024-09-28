package com.jo.order.controller;

import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jo.order.dto.CommonAsyncResponse;
import com.jo.order.dto.OrderDto;
import com.jo.order.service.OrderService;
import com.jo.order.util.EventProcessEnum;

@RestController
@RequestMapping("order")
public class OrderController {
	
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private ExecutorService asyncThreadPool;

	@PostMapping
	public ResponseEntity<CommonAsyncResponse> order(@RequestBody OrderDto orderDto) {
		logger.info("Processing order {}", orderDto.getOrderId());
		asyncThreadPool.submit(() -> {
			orderService.processOrder(orderDto);
		});
		return new ResponseEntity<CommonAsyncResponse>(
				new CommonAsyncResponse(EventProcessEnum.PROCESSING_ORDER, "Order is under process"), HttpStatus.OK);
	}

}
