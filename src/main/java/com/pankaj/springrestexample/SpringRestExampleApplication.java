package com.pankaj.springrestexample;


import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class SpringRestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExampleApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localResolver= new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
		
	}
	// instedd of this we can use 
	//spring.messages.basename=messages
	// commenting this method
	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * 
	 * ResourceBundleMessageSource resMsgSource= new ResourceBundleMessageSource();
	 * resMsgSource.setBasename("messages"); return resMsgSource;
	 * 
	 * }
	 */

}
