package com.oli.authdemo.model;

import javax.validation.constraints.NotNull;

public class TransactionModel {
	
	@NotNull(message="Enter a valid amount")
	private double amount;
	
	private int acno;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	@Override
	public String toString() {
		return "TransactionModel [amount=" + amount + ", acno=" + acno + "]";
	}
	
	
	
	

}
