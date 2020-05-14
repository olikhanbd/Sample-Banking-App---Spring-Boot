package com.oli.authdemo.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Customer> getCustomerByNid(int nid){
		return customerRepo.findByNid(nid);
	}
	
	public Optional<AuthAccount> getAccountById(int id){
		return acRepo.findById(id);
	}
	
	public void insertCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public void insertAccount(AuthAccount acc) {
		acRepo.save(acc);
	}
	
	public void updateAccount(AuthAccount acc) {
		AuthAccount acToUpdate = acRepo.getOne(acc.getAcno());
		acToUpdate.setBalance(acc.getBalance());
		acToUpdate.setCreateDate("25-JUN-53");
		acRepo.save(acToUpdate);
	}
	
	public void updateCustomer(Customer customer) {
		Customer c = customerRepo.getOne(customer.getCid());
		c.setDob("25-JUN-53");
		c.setPhoto(customer.getPhoto());
		c.setNidPhoto(customer.getNidPhoto());
		
		customerRepo.save(c);
	}

}
