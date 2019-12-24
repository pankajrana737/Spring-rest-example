package com.pankaj.springrestexample.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Primary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
@ApiModel(description = "USer class stroe datils about user ")
@ApiOperation(value = "get-users")
public class User {

private Integer id;
@Size(min=2)
@ApiModelProperty(notes = "username must have 2 charcaters ")
private String name;
@Past
private Date birthDate;
@ApiModelProperty(notes = "birth day can be in past date")
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
