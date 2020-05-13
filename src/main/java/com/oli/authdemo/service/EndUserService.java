package com.oli.authdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oli.authdemo.dao.AccountRepository;
import com.oli.authdemo.dao.AccountTypeRepository;
import com.oli.authdemo.dao.UserRepository;
import com.oli.authdemo.model.Account;
import com.oli.authdemo.model.AccountType;
import com.oli.authdemo.model.User;

@Service
public class EndUserService {
	
	@Autowired
	private AccountRepository acRepo;
	
	@Autowired
	private AccountTypeRepository acTypeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public void insertAccount(Account ac) {
		acRepo.save(ac);
	}
	
	public List<Account> getAllAccounts(){
		return acRepo.findAll();
	}
	
	public Optional<Account> getAccountByNumber(int acno){
		return acRepo.findById(acno);
	}
	
	public Optional<User> getUserByEmail(String email){
		return userRepo.findByEmail(email);
	}
	
	public void updateAccount(Account account) {
		Account acToUpdate = acRepo.getOne(account.getAcNumber());
		
		acToUpdate.setAcNumber(account.getAcNumber());
		acToUpdate.setCustomerName(account.getCustomerName());
		acToUpdate.setFathersName(account.getFathersName());
		acToUpdate.setMothersName(account.getMothersName());
		acToUpdate.setDob(account.getDob());
		acToUpdate.setAddress(account.getAddress());
		acToUpdate.setPhoneNo(account.getPhoneNo());
		acToUpdate.setNid(account.getNid());
		acToUpdate.setAcType(account.getAcType());
		acToUpdate.setPhoto(account.getPhoto());
		acToUpdate.setNidPhoto(account.getNidPhoto());
		
		acRepo.save(acToUpdate);
		
	}
	
	public List<AccountType> getAccountTypes(){
		return acTypeRepo.findAll();
	}

}
