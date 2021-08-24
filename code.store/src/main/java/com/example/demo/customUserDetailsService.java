package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class customUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		User user = repo.findByMail(mail);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new customUserDetails(user);
	}

}
