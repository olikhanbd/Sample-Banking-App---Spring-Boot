package com.oli.authdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oli.authdemo.dao.EmployeeRepository;
import com.oli.authdemo.dao.MenuRepository;
import com.oli.authdemo.dao.RoleRepository;
import com.oli.authdemo.dao.UserRepository;
import com.oli.authdemo.model.Employee;
import com.oli.authdemo.model.Menu;
import com.oli.authdemo.model.Role;
import com.oli.authdemo.model.User;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private MenuRepository menuRepo;
	
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
	
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepo.findById(id);
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
	
	public void insertRole(Role role) {
		roleRepo.save(role);
	}
	
	public List<Role> getRoles(){
		return roleRepo.findAll();
	}
	
	public void insertMenu(Menu menu) {
		menuRepo.save(menu);
	}
	
	public List<Menu> getMenus(){
		return menuRepo.findAll();
	}

}
