package com.eduardobarrera.todoapp.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCrypt.
 */
public class TestCrypt {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		System.out.println(passEncoder.encode("admin"));

	}

}
