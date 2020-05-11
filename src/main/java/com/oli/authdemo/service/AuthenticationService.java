package com.oli.authdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oli.authdemo.dao.UserRepository;

import com.oli.authdemo.model.User;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepo;

	
	public Optional<User> validateUser(String email, String pass) {
		System.out.println(email + " " + pass);
		return userRepo.findByEmailAndPassword(email, pass);
	}
	
	public Optional<User> findUserById(int id){
		return userRepo.findById(id);
	}
	
	public Optional<User> findUserByEmail(String e){
		return userRepo.findByEmail(e);
	}
	
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	
	public void insertUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser(User user) {
		User userToUpdate = userRepo.getOne(user.getId());
		
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setMobile(user.getMobile());
		userToUpdate.setStatus(user.getStatus());
		userToUpdate.setRole(user.getRole());
		
		userRepo.save(userToUpdate);
	}

}
