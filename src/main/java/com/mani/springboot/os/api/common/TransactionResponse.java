package com.mani.springboot.os.api.common;

import com.mani.springboot.os.api.entity.Order;

public class TransactionResponse {
	private Order order;
	private double amount;
	private String transactionId;
	private String message;
	
	
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResponse(Order order2, double amount2, String transactionId2, String response) {
		this.order=order;
		this.amount=amount;
		this.transactionId=transactionId;
		this.message=message;
		
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "TransactionResponse [order=" + order + ", amount=" + amount + ", transactionId=" + transactionId
				+ ", message=" + message + "]";
	}
	
	
}
