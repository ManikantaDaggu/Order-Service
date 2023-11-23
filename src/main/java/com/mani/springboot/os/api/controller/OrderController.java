package com.mani.springboot.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mani.springboot.os.api.common.Payment;
import com.mani.springboot.os.api.common.TransactionRequest;
import com.mani.springboot.os.api.common.TransactionResponse;
import com.mani.springboot.os.api.entity.Order;
import com.mani.springboot.os.api.service.Orderservice;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private Orderservice service;
	
	@PostMapping("/bookorder")
	public TransactionResponse bookorder(@RequestBody TransactionRequest request) {
		
		return service.saveOrder(request);
		
	}
}
