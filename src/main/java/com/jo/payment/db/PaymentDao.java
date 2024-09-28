package com.jo.payment.db;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jo.payment.dto.PaymentDto;

@Component
public class PaymentDao  {
	private static List<PaymentDto> list = new ArrayList<>();
	
	private static Logger logger = LoggerFactory.getLogger(PaymentDao.class);
	
	public void save(PaymentDto paymentDto) {
		logger.info("Order data has been saved in DB.");
		list.add(paymentDto);
	}
	
	public void delete(PaymentDto paymentDto) {
		list.remove(paymentDto);
	}
}
