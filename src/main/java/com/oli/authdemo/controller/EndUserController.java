package com.oli.authdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oli.authdemo.model.Account;
import com.oli.authdemo.model.AccountType;
import com.oli.authdemo.model.ChangePassModel;
import com.oli.authdemo.model.PhotoModel;
import com.oli.authdemo.model.Employee;
import com.oli.authdemo.model.User;
import com.oli.authdemo.service.AuthenticationService;
import com.oli.authdemo.service.EndUserService;
import com.oli.authdemo.utils.Constants;
import com.oli.authdemo.utils.RandomString;

@Controller
public class EndUserController {
	
	@Autowired
	private EndUserService service;
	
	@Autowired
	private AuthenticationService authService;
	
	@GetMapping("/accounts")
	public ModelAndView getAccounts() {
	
		List<Account> accounts = service.getAllAccounts();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("accounts", accounts);
		mv.setViewName("accounts");
		
		return mv;
	}
	
	@GetMapping("/openaccount")
	public ModelAndView openAccount(Model model) {
		ModelAndView mv = new ModelAndView();
		Account account = new Account();
		model.addAttribute("account", account);
		List<AccountType> actypes = service.getAccountTypes();
		mv.setViewName("openaccount");
		mv.addObject("actypes", actypes);
		
		return mv;
	}
	
	@RequestMapping(value = { "/openaccount" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Account account, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("openaccount");
    	
    	if(bindingResult.hasErrors()) {
    		List<AccountType> actypes = service.getAccountTypes();
    		return mv;
    	}
		
    	System.out.println(account.toString());
    	
    	service.insertAccount(account);
    	
    	mv.addObject("message", "Account created Successfully");
    	
		return mv;
		
	}
	
	@GetMapping("/uploaddocuments")
	public ModelAndView uploadDocuments(@RequestParam("id") int acid, Model model) {
		Optional<Account> account = service.getAccountByNumber(acid);
		
		model.addAttribute(new PhotoModel());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploaddocument");
		mv.addObject("account", account.get());
		
		return mv;
	}
	
	@RequestMapping(value = {"/uploadphoto"}, method = RequestMethod.POST)
	public ModelAndView uploadPhoto(@RequestParam("photo") MultipartFile file, @RequestParam("acno") int acno) {
		ModelAndView mv = new ModelAndView();
		Optional<Account> account = service.getAccountByNumber(acno);
		mv.setViewName("uploaddocument");
		mv.addObject("account", account.get());
		
		Path fileNameAndPath = Paths.get(Constants.UPLOAD_DIR, file.getOriginalFilename());
		
		try {
			Files.write(fileNameAndPath, file.getBytes());
			
			account.get().setPhoto(file.getOriginalFilename());
			
			service.updateAccount(account.get());
			
			mv.addObject("messagephoto", "Photo uploaded Successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("messagephoto", "Photo uploaded failed");
		}
		
		return mv;
	}
	
	@RequestMapping(value = {"/uploadnid"}, method = RequestMethod.POST)
	public ModelAndView uploadNid(@RequestParam("nid") MultipartFile file, @RequestParam("acno") int acno) {
		ModelAndView mv = new ModelAndView();
		Optional<Account> account = service.getAccountByNumber(acno);
		mv.setViewName("uploaddocument");
		mv.addObject("account", account.get());
		
		Path fileNameAndPath = Paths.get(Constants.UPLOAD_DIR, file.getOriginalFilename());
		
		try {
			Files.write(fileNameAndPath, file.getBytes());
			
			account.get().setNidPhoto(file.getOriginalFilename());
			
			service.updateAccount(account.get());
			
			mv.addObject("messagenid", "Photo uploaded Successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("messagenid", "Photo uploaded failed");
		}
		
		return mv;
	}
	
	@RequestMapping(value= {"/settings"}, method = RequestMethod.GET)
	public String settingsPage(Model model) {
		
		model.addAttribute(new ChangePassModel());
		
		return "settings";
	}
	

	@RequestMapping(value = {"/changepass"}, method = RequestMethod.POST)
	public ModelAndView changePass(@Valid ChangePassModel cpm, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("settings");
		
		if(bindingResult.hasErrors()) {
			return mv;
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Optional<User> user = service.getUserByEmail(auth.getName());
		
		System.out.println(user.get().toString());
		
		if(user.isPresent() && user.get().getPassword().equals(cpm.getOldPass())) {
			user.get().setPassword(cpm.getNewPass());
			authService.updateUser(user.get());
			mv.addObject("message", "Password changed successfully");
		} else {
			mv.addObject("message", "Password did not match");
		}
		
		return mv;
	}
	
	@GetMapping("/search")
	public String gotoSearch() {
		return "search";
	}
	
	@GetMapping("/searchaccount")
	public ModelAndView searchAccount(@RequestParam("acno") int acno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search");
		
		Optional<Account> account = service.getAccountByNumber(acno);
		
		if(account.isPresent()) {
			mv.addObject("accountFound", true);
			mv.addObject("account", account.get());
			
		} else {
			mv.addObject("accountFound", false);
			mv.addObject("message", "Account not found!");
		}
		
		
		return mv;
	}
	
}
