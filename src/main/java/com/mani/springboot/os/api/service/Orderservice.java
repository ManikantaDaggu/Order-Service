package com.mani.springboot.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mani.springboot.os.api.common.Payment;
import com.mani.springboot.os.api.common.TransactionRequest;
import com.mani.springboot.os.api.common.TransactionResponse;
import com.mani.springboot.os.api.entity.Order;
import com.mani.springboot.os.api.repository.OrderRepository;

@Service
public class Orderservice {
	
	@Autowired
	private OrderRepository orderrepository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response= "";
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentresponse=template.postForObject("http://localhost:9191/payment/dopayment", payment, Payment.class);
		response=paymentresponse.getPaymentstatus().equals("success")?"Payment Successful":"something went wrong";
		// System.out.println(response);
		// System.out.println(paymentresponse.getTransactionId());
		 orderrepository.save(order);
		 // System.out.println(paymentresponse.toString());
		 return new TransactionResponse(order,paymentresponse.getAmount(),paymentresponse.getTransactionId(),response);
		// TransactionResponse tr=new TransactionResponse(order,paymentresponse.getAmount(),paymentresponse.getTransactionId(),response);
		// System.out.println(tr.toString());
		// return tr;
	}

}
