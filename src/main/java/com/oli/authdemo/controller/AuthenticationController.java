package com.oli.authdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oli.authdemo.model.User;
import com.oli.authdemo.service.AuthenticationService;


@Controller
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	@RequestMapping("/")
	public String welcome() {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String pass) {
		
		Optional<User> user = authService.validateUser(email, pass);
		
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("user is null");
		}
		
		System.out.println(email + " " + pass);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		modelAndView.addObject("error", true);
		return modelAndView;
	}

}
