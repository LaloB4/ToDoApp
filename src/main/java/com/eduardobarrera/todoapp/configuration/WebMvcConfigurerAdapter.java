package com.eduardobarrera.todoapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.eduardobarrera.todoapp.component.RequestTimeInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class WebMvcConfigurerAdapter.
 */
@Configuration
public class WebMvcConfigurerAdapter extends org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter{
	
	/** The request TI. */
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTI;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTI);
	}
	
	
	
}
