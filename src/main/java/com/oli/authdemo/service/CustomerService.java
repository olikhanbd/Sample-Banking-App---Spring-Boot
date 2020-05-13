package com.oli.authdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oli.authdemo.dao.AuthAccountRepository;
import com.oli.authdemo.dao.CustomerRepository;
import com.oli.authdemo.model.AuthAccount;
import com.oli.authdemo.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private AuthAccountRepository acRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public List<AuthAccount> getAccounts(){
		return acRepo.findAll();
	}
	
	public List<Customer> getCustomers(){
		return customerRepo.findAll();
	}

}
