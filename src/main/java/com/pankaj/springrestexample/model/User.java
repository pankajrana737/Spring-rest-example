package com.pankaj.springrestexample.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

private Integer id;
@Size(min=2)
private String name;
@Past
private Date birthDate;
private List<Post> posts;
public List<Post> getPosts() {
	return posts;
}
public void setPosts(List<Post> posts) {
	this.posts = posts;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public User(Integer id, String name, Date birthDate, List<Post> posts) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
	this.posts = posts;
}


}
