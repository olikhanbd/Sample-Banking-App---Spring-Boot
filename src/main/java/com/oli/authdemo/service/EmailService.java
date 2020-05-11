package com.oli.authdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.oli.authdemo.model.User;

@Service
public class EmailService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(User user) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmail());
		mail.setFrom("oli.csecu@gmail.com");
		mail.setSubject("Sample banking application username and password");
		mail.setText(""
				+ "An user has been created for you in the sample banking application. "
				+ "Use the following credentials to log in to the system.\n\n"
				+ ""
				+ "username: " + user.getEmail()+"\n"
				+"password: " + user.getPassword()+"\n\n"
				+""
				+ "Regards\n"
				+ "Sample banking app team");
		
		javaMailSender.send(mail);
	}

}
