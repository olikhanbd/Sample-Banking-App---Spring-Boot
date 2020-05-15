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
import com.oli.authdemo.model.AuthAccount;
import com.oli.authdemo.model.ChangePassModel;
import com.oli.authdemo.model.Customer;
import com.oli.authdemo.model.PhotoModel;
import com.oli.authdemo.model.TransactionModel;
import com.oli.authdemo.model.Employee;
import com.oli.authdemo.model.User;
import com.oli.authdemo.service.AuthenticationService;
import com.oli.authdemo.service.CustomerService;
import com.oli.authdemo.service.EndUserService;
import com.oli.authdemo.utils.Constants;
import com.oli.authdemo.utils.RandomString;

@Controller
public class EndUserController {
	
	@Autowired
	private EndUserService service;
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/accounts")
	public ModelAndView getAccounts() {
	
		List<AuthAccount> accounts = customerService.getAccounts();
		
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
    	
    	System.out.println(account.getDob());
    	System.out.println(account.getCreateDate());
    	
    	System.out.println(Constants.formatDate(account.getDob()));
    	System.out.println(Constants.formatDate(account.getCreateDate()));
    	
    	account.setDob(Constants.formatDate(account.getDob()));
		account.setCreateDate(Constants.formatDate(account.getCreateDate()));
		
    	Optional<Customer> checkCustomer = customerService.getCustomerByNid(account.getNid());
    	
    	if(checkCustomer.isPresent()) {
    	
    		System.out.println("customer found");
    	
//    		customerService.insertCustomer(generateCustomer(account));
    	
//    		Optional<Customer> customer = customerService.getCustomerByNid(account.getNid());
    		
    		customerService.insertAccount(generateAccount(account, checkCustomer.get()));
    	} else {
    		System.out.println("customer not found");
    		customerService.insertCustomer(generateCustomer(account));
    		Optional<Customer> customer = customerService.getCustomerByNid(account.getNid());
    		customerService.insertAccount(generateAccount(account, customer.get()));
    	}
    	
    	
//    	service.insertAccount(account);
    	
    	mv.addObject("message", "Account created Successfully");
    	
		return mv;
		
	}
	
	@GetMapping("/uploaddocuments")
	public ModelAndView uploadDocuments(@RequestParam("id") int acid, Model model) {
		Optional<AuthAccount> account = customerService.getAccountById(acid);
		
		model.addAttribute(new PhotoModel());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploaddocument");
		mv.addObject("account", account.get());
		
		return mv;
	}
	
	@RequestMapping(value = {"/uploadphoto"}, method = RequestMethod.POST)
	public ModelAndView uploadPhoto(@RequestParam("photo") MultipartFile file, @RequestParam("acno") int acno) {
		ModelAndView mv = new ModelAndView();
		Optional<AuthAccount> account = customerService.getAccountById(acno);
		mv.setViewName("uploaddocument");
		mv.addObject("account", account.get());
		
		Path fileNameAndPath = Paths.get(Constants.UPLOAD_DIR, file.getOriginalFilename());
		
		try {
			Files.write(fileNameAndPath, file.getBytes());
			
			account.get().getCustomer().setPhoto(file.getOriginalFilename());
			
			customerService.updateCustomer(account.get().getCustomer());
			
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
		Optional<AuthAccount> account = customerService.getAccountById(acno);
		mv.setViewName("uploaddocument");
		mv.addObject("account", account.get());
		
		Path fileNameAndPath = Paths.get(Constants.UPLOAD_DIR, file.getOriginalFilename());
		
		try {
			Files.write(fileNameAndPath, file.getBytes());
			
			account.get().getCustomer().setNidPhoto(file.getOriginalFilename());
			
			customerService.updateCustomer(account.get().getCustomer());
			
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
		
		Optional<AuthAccount> account = customerService.getAccountById(acno);
		
		if(account.isPresent()) {
			mv.addObject("accountFound", true);
			mv.addObject("account", account.get());
			
		} else {
			mv.addObject("accountFound", false);
			mv.addObject("message", "Account not found!");
		}
		
		
		return mv;
	}
	
	@GetMapping("/deposit")
	public ModelAndView deposit(@RequestParam("id") int id, Model model) {
		model.addAttribute(new TransactionModel());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deposit");
		mv.addObject("acno", id);
		return mv;
	}
	
	@RequestMapping(value = {"/deposit"}, method = RequestMethod.POST)
	public ModelAndView deposit(@Valid TransactionModel tm, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deposit");
		
		if(bindingResult.hasErrors()) {
			return mv;
		}
		
		System.out.println(tm.getAcno() + " " +tm.getAmount());
		
		customerService.depositMoney(tm.getAcno(), tm.getAmount());
		
		mv.addObject("message", "Deposit Successful");
		
		return mv;
	}
	
	@GetMapping("/withdraw")
	public ModelAndView withdraw(@RequestParam("id") int id, Model model) {
		
		model.addAttribute(new TransactionModel());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("withdraw");
		mv.addObject("acno", id);
		return mv;
	}
	
	@RequestMapping(value = {"/withdraw"}, method = RequestMethod.POST)
	public ModelAndView withdraw(@Valid TransactionModel tm, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("withdraw");
		
		if(bindingResult.hasErrors()) {
			return mv;
		}
		
		Optional<AuthAccount> authAc = customerService.getAccountById(tm.getAcno());
		
		if(authAc.isPresent()) {
			if(authAc.get().getBalance() < tm.getAmount()) {
				mv.addObject("message", "Not enough balance");
				return mv;
			}
		}
		
		customerService.withdrawMoney(tm.getAcno(), tm.getAmount());
		
		mv.addObject("message", "Withdraw Successful");
		
		return mv;
	}
	
	@GetMapping("/test")
	public String getCustomers() {
		
		List<Customer> customers = customerService.getCustomers();
		List<AuthAccount> accounts = customerService.getAccounts();
		
	
		
		System.out.println(customers.toString());
		System.out.println(accounts.toString());
		
		return "search";
	}
	
	private Customer generateCustomer(Account acc) {
		Customer customer = new Customer();
		customer.setCname(acc.getCustomerName());
		customer.setDob(acc.getDob());
		customer.setFname(acc.getFathersName());
		customer.setMname(acc.getMothersName());
		customer.setAddress(acc.getAddress());
		customer.setPhoneno(acc.getPhoneNo());
		customer.setNid(acc.getNid());
		customer.setPhoto(acc.getPhoto());
		customer.setNidPhoto(acc.getNidPhoto());
		
		return customer;
	}
	
	private AuthAccount generateAccount(Account ac, Customer customer) {
		AuthAccount act = new AuthAccount();
		act.setCreateDate(ac.getCreateDate());
		act.setAcType(ac.getAcType());
		act.setBalance(ac.getBalance());
		act.setCustomer(customer);
		
		return act;
	}
	
}
