package com.oli.authdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="auth_account", schema = "hr")
public class AuthAccount {

	@Id
	@Column(name="ACNO")
	@GeneratedValue(generator = "AC_SEQ")
	@SequenceGenerator(name = "AC_SEQ", sequenceName = "auth_account_Sequence",allocationSize = 1, initialValue = 1, schema="hr")
	private int acno;
	
	//@Column(name="customer_id")
	//private int customerId;
	
	@Column(name="CREATE_DATE")
	private String createDate;
	
	@Column(name="BALANCE")
	private int balance;
	
	@Column(name="AC_TYPE")
	private String acType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
	@JsonBackReference
    private Customer customer;

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AuthAccount [acno=" + acno + ", createDate=" + createDate + ", balance=" + balance
				+ ", acType=" + acType + ", customer=" + customer.getCid() + "]";
	}
	
	
}
