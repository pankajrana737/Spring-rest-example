package com.pankaj.springrestexample;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pankaj.springrestexample.exception.UserNotFoundException;
import com.pankaj.springrestexample.model.User;
import com.pankaj.springrestexample.service.UserDaoService;

@RestController
public class UserlController {
	
	@Autowired
	UserDaoService userService;
	// get all user
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.reteriveAllUsers();
		
	}


	// get specfic user
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id){
		User findUser = userService.findUser(id);
		if(findUser==null) {
			throw new UserNotFoundException("no record found with this id : "+id);
		}
		return findUser;
		
	}
	
	// add new user in static list
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(location).build();
		
	}
}