package com.jo.payment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.payment.db.PaymentDao;
import com.jo.payment.dto.PaymentDto;

@Service
public class PaymentServiceUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentServiceUtil.class);
	
	@Autowired
	private PaymentDao paymentDao;
	
	public PaymentDto processPayment(PaymentDto paymentDto) {
		if(paymentDto.getOrderId()>0) {
			paymentDao.save(paymentDto);
			logger.info("Payment has been saved in DB {}", paymentDto.getOrderId());
		}else {
			logger.info("Payment Failed {}", paymentDto.getOrderId());	
			throw new RuntimeException("Payment Failed");
		}
		return paymentDto;
	}
}
