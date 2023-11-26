package com.bms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entity.Payment;
import com.bms.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PaymentController {
	
	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payments")
	public ResponseEntity<String> createOrder(@RequestBody Payment payment) throws JsonProcessingException {
		
		logger.info(" /backend/payments API called with payment data {}", payment);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(paymentService.makePayment(payment));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}
}