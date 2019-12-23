package com.pankaj.springrestexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.springrestexample.model.User;
import com.pankaj.springrestexample.service.UserDaoService;

@RestController
public class UserlController {
	
	@Autowired
	UserDaoService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.reteriveAllUsers();
		
	}

}
