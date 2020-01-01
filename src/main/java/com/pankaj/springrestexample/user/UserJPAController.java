package com.pankaj.springrestexample.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pankaj.springrestexample.exception.UserNotFoundException;
import com.pankaj.springrestexample.model.Post;
import com.pankaj.springrestexample.model.User;
import com.pankaj.springrestexample.model.User;
import com.pankaj.springrestexample.service.UserDaoService;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
@RestController
public class UserJPAController {
	

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PostRepository postRepository;
	// get all user
	@GetMapping("/jpa/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
		
	}


	// get specfic user
	@GetMapping("/jpa/users/{id}")
//	public EntityModel<User> getUserById(@PathVariable int id){
	public Resource<User> getUserById(@PathVariable int id){
		Optional<User> findUser = userRepository.findById(id);
		if(!findUser.isPresent()) {
			throw new UserNotFoundException("no record found with this id : "+id);
		}
		// applying hateos
		// add all users
		// if used boot 2.2.0
		/*
		 * EntityModel<User> model = new EntityModel<>(findUser); WebMvcLinkBuilder
		 * linkTo = linkTo(methodOn(this.getClass()).getAllUser());
		 * model.add(linkTo.withRel("all-users"));
		 * return model;
		 */
		//finderuser.get return actual user from optional
		Resource<User> resource = new Resource<User>(findUser.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(linkTo.withRel("all-users"));
		return resource;
		
		
	}
	
	// add new user in static list
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(location).build();
		
	}
	
	 @DeleteMapping("/jpa/users/{id}")
	 public void deleteUserbyID(@PathVariable int id) {
		  userRepository.deleteById(id);
	 }
	 // get user specific post
	 @GetMapping("/jpa/users/{id}/posts")
//		public EntityModel<User> getUserById(@PathVariable int id){
		public List<Post> getUserPostById(@PathVariable int id){
			Optional<User> findUser = userRepository.findById(id);
			if(!findUser.isPresent()) {
				throw new UserNotFoundException("no record found with this id : "+id);
			}
			
			return findUser.get().getPost();
			
			
		}
		// create post for a specific user
	 
	 @PostMapping("/jpa/users/{id}/posts")
		public ResponseEntity<Object> savePost(@PathVariable int id,@Valid @RequestBody Post post){
		
		 Optional<User> findUser = userRepository.findById(id);
			if(!findUser.isPresent()) {
				throw new UserNotFoundException("no record found with this id : "+id);
			}
			User user= findUser.get();
			post.setUser(user);
			postRepository.save(post);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(post.getId()).toUri();
				return ResponseEntity.created(location).build();
			
		}
}
