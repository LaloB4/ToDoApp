package com.eduardobarrera.todoapp.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		System.out.println(passEncoder.encode("admin"));

	}

}
