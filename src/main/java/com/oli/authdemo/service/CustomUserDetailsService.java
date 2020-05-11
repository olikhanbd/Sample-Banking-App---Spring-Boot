package com.oli.authdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oli.authdemo.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private AuthenticationService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = service.findUserByEmail(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		return user.map(CustomUserDetails::new).get();
	}
	
	

}
