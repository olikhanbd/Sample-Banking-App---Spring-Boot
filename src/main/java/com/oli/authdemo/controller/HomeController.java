package com.oli.authdemo.controller;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oli.authdemo.model.Account;
import com.oli.authdemo.model.Employee;
import com.oli.authdemo.model.Menu;
import com.oli.authdemo.model.PostId;
import com.oli.authdemo.model.Role;
import com.oli.authdemo.model.User;
import com.oli.authdemo.service.AuthenticationService;
import com.oli.authdemo.service.EmailService;
import com.oli.authdemo.service.EndUserService;
import com.oli.authdemo.utils.RandomString;

@Controller
public class HomeController {
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		
		ModelAndView mv = new ModelAndView();
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("admin"))) {
			System.out.println("Admin");
			mv.setViewName("users");
			List<User> users = authService.findAllUser();
			
			mv.addObject("users", users);
			return mv;
		} else if(auth.getAuthorities().contains(new SimpleGrantedAuthority("user"))){
			System.out.println("User");
			List<Account> accounts = endUserService.getAllAccounts();
			
			mv.addObject("accounts", accounts);
			mv.setViewName("accounts");
			
			return mv;
		}
		System.out.println("not logged in");
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/users")
	public ModelAndView getUsers() {
	
		List<User> users = authService.findAllUser();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", users);
		mv.setViewName("users");
		
		return mv;
	}
	
	@GetMapping("/customers")
	public ModelAndView getCustomers() {
	
//		List<User> users = authService.findAllUser();
		
		ModelAndView mv = new ModelAndView();
//		mv.addObject("users", users);
		mv.setViewName("customers");
		
		return mv;
	}
	
	@GetMapping("/createuser")
	public ModelAndView createUserPage(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createuser");
		
		List<Role> roles = authService.getRoles();
		mv.addObject("roles", roles);
	
		return mv;
	}
	
	@RequestMapping(value = { "/createuser" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("createuser");
    	
    	if(bindingResult.hasErrors()) {
    		List<Role> roles = authService.getRoles();
    		mv.addObject("roles", roles);
    		return mv;
    	}
    	
    	Optional<Employee> emp = authService.getEmployeeById(user.getId());
    	
    	if(emp.isPresent()) {
    		System.out.println(emp.toString());
    		
    		String pass = RandomString.generateString(8);
			
			user.setPassword(pass);
			
			System.out.println(user.toString());
			
			authService.insertUser(user);
			
			mv.addObject("message", "User created Successfully");
			
			try {
				emailService.sendEmail(user);
			} catch (MailException e) {
				System.out.println(e.toString());
			}
			
    	} else {
    		System.out.println("employee empty");
    		mv.addObject("message", "Employee not found");
    	}
    	
        return mv;
		
	}
	
	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam("id") int id, Model model) {
		
		Optional<User> user = authService.findUserById(id);
		
		model.addAttribute("user", new User());
		model.addAttribute("role", new Role());
		
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("user is null");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateuser"); // resources/template/login.html
		modelAndView.addObject("user", user.get());
		List<Role> roles = authService.getRoles();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}
	
	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.POST)
	public ModelAndView updateUser(@Valid User user, BindingResult bindingResult, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		model.addAttribute("user", user);
		model.addAttribute("role", user.getRole());
		
    	
    	mv.setViewName("updateuser");
		
		if(bindingResult.hasErrors()){
			mv.addObject("message", "User update failed");
			return mv;
		}
		
		System.out.println(user.toString());
		
		authService.updateUser(user);
		
		mv.addObject("message", "User updated Successfully");
		
		return mv;
		
	}
	
	@RequestMapping(value = { "/resetpassword" }, method = RequestMethod.GET)
	public ModelAndView resetPassword(@RequestParam("id") int id) {
		Optional<User> user = authService.findUserById(id);
		
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("user is null");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("resetpassword"); // resources/template/login.html
		modelAndView.addObject("user", user.get());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/resetpassword" }, method = RequestMethod.POST)
	public ModelAndView resetPassword(PostId postId) {
		ModelAndView mv = new ModelAndView();
		System.out.println(postId.toString());
		
		Optional<User> user = authService.findUserById(postId.getId());
		
		if(user != null) {
			System.out.println(user.toString());
			
			String pass = RandomString.generateString(8);
			System.out.println("Previouse pass: " + user.get().getPassword());
			System.out.println("New pass: " + pass);
			user.get().setPassword(pass);
			
			authService.updateUser(user.get());
			
			mv.addObject("message", "Password Reset Successful");
			
			try {
				emailService.sendEmail(user.get());
			} catch (MailException e) {
				System.out.println(e.toString());
			}
			
		} else {
			System.out.println("user is null");
		}
		
		mv.setViewName("resetpassword");
		
		return mv;
		
	}
	
	@GetMapping("/addmenu")
	public ModelAndView addMenu(Model model) {
		ModelAndView mv = new ModelAndView();
		Menu menu = new Menu();
//		List<Role> roles = authService.getRoles();
//		System.out.println(roles.toString());
		model.addAttribute("menu", menu);
		
//		mv.addObject("roles", roles);
		mv.setViewName("addmenu");
	
		return mv;
	}
	
	@RequestMapping(value = { "/addmenu" }, method = RequestMethod.POST)
	public ModelAndView addMenu(@Valid Menu menu, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView();
		
    	
		mv.setViewName("addmenu");
		
		if(bindingResult.hasErrors()) {
			List<Role> roles = authService.getRoles();
			mv.addObject("roles", roles);
			return mv;
		}
		authService.insertMenu(menu);
		mv.addObject("message", "Menu created successfully");
		
		return mv;
		
		
	}
	
	@GetMapping("/addrole")
	public String AddRole(Model model) {
		
		Role role = new Role();
		
		model.addAttribute("role", role);
	
	
		return "addrole";
	}
	
	@RequestMapping(value = { "/addrole" }, method = RequestMethod.POST)
	public ModelAndView addRole(@Valid Role role, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addrole");
		
		if(bindingResult.hasErrors()) {
			return mv;
		}
		
		authService.insertRole(role);
		mv.addObject("message", "Role created successfully");
		
		return mv;
		
		
	}

}
