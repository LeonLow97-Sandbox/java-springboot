package com.alibou.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

	@JsonProperty("c-name")
	private String customerName;
	@JsonProperty("p-name")
	private String productName;
	@JsonProperty("quantity")
	private int quantity;

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "{" +
			" customerName='" + getCustomerName() + "'" +
			", productName='" + getProductName() + "'" +
			", quantity='" + getQuantity() + "'" +
			"}";
	}
	
}
