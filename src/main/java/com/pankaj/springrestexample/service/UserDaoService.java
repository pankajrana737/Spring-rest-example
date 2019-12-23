package com.pankaj.springrestexample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pankaj.springrestexample.model.User;

@Component
public class UserDaoService {
	
 private static int userId=6;
 private static List<User> users= new ArrayList<>();
 static {
	 users.add(new User(1, "Pankaj Rana", new Date()));

	 users.add(new User(2, "Tommy", new Date()));

	 users.add(new User(3, "Jeery", new Date()));
	 

	 users.add(new User(4, "John doe", new Date()));

	 users.add(new User(5, "Merry Jane", new Date()));


 }
 //
public List<User> reteriveAllUsers(){
	return users;
}
	
}
