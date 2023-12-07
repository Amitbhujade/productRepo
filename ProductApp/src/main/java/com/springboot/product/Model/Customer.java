package com.springboot.product.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer 
{
	@Id 
	@GeneratedValue
	int customerId;
	String customerName;
	double customerBudget;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getCustomerBudget() {
		return customerBudget;
	}
	public void setCustomerBudget(double customerBudget) {
		this.customerBudget = customerBudget;
	}
	
	public Customer(int customerId, String customerName, double customerBudget) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerBudget = customerBudget;
	}
	
	public Customer() {
		super();
	}
	
	
	
	
}
