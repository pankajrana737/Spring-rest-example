package com.pankaj.springrestexample;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/helloWorld")
	public String Greeting(@RequestHeader(name="Accept-Language",required = false,defaultValue = "US") Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}

}
