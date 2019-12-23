package com.pankaj.springrestexample.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pankaj.springrestexample.model.Post;
import com.pankaj.springrestexample.model.User;

@Component
public class UserDaoService {
	
 private static int userId=6;
 private static List<User> users= new ArrayList<>();
 private static List<Post> post=new ArrayList<>();
 static {
	 post.add(new Post(new Date(), "CAB", "impleneted Cab"));
	 post.add(new Post(new Date(), "TESt", "Test 1"));
	 post.add(new Post(new Date(), "Test 2", "impleneted Cab"));
	 post.add(new Post(new Date(), "Test", "impleneted testing"));
 }
 static {
	 
	 
	 users.add(new User(1, "Pankaj Rana", new Date(),post));

	 users.add(new User(2, "Tommy", new Date(),post));

	 users.add(new User(3, "Jeery", new Date(),post));
	 

	 users.add(new User(4, "John doe", new Date(),post));

	 users.add(new User(5, "Merry Jane", new Date(),post));


 }
 //
public List<User> reteriveAllUsers(){
	return users;
}
 public User save(User user) {
	 if(user.getId()==null) {
		 user.setId(++userId);
		 
	 }
	 users.add(user);
	return user;
	 
 }
 
 public User findUser(int id) {
	 for(User user :users) {
		 if(user.getId()==id) {
			 return user;
		 }
	 }
	return null;
	 
 }
	
}
