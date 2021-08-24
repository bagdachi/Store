package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass= "asdfg";
		String newpass=encoder.encode(pass);
		System.out.println(newpass);

	}

}
