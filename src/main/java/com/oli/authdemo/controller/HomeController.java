package com.oli.authdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oli.authdemo.model.User;
import com.oli.authdemo.service.AuthenticationService;
import com.oli.authdemo.utils.RandomString;

@Controller
public class HomeController {
	
	@Autowired
	private AuthenticationService authService;
	
	@GetMapping("/")
	public ModelAndView homePage() {
	
		List<User> users = authService.findAllUser();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", users);
		mv.setViewName("users");
		
		return mv;
	}
	
	@GetMapping("/createuser")
	public String createUserPage(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
	
		return "createuser";
	}
	
	@RequestMapping(value = { "/createuser" }, method = RequestMethod.POST)
	public String createUser(@Valid User user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {       
	         
	        return "createuser";
	    } else {
	    	String pass = RandomString.generateString(8);
			
			user.setPassword(pass);
			
			System.out.println(user.toString());
			
			authService.insertUser(user);
			
	        return "users";
	    }
		
		
		
	}
	
	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam("id") int id) {
		
		Optional<User> user = authService.findUserById(id);
		
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("user is null");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateuser"); // resources/template/login.html
		modelAndView.addObject("user", user.get());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.POST)
	public void updateUser(User user) {
		
		System.out.println(user.toString());
		
		authService.updateUser(user);
		
	}

}
