package com.pankaj.springrestexample.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Primary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
@ApiModel(description = "USer class stroe datils about user ")
@ApiOperation(value = "get-users")
@Entity
public class User {

	@Id
	@GeneratedValue
private Integer id;
@Size(min=2)
@ApiModelProperty(notes = "username must have 2 charcaters ")
private String name;
@Past
private Date birthDate;
@ApiModelProperty(notes = "birth day can be in past date")

@OneToMany(mappedBy ="user")
private List<Post> post;



public List<Post> getPost() {
	return post;
}

public void setPost(List<Post> post) {
	this.post = post;
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


public User(Integer id, @Size(min = 2) String name, @Past Date birthDate, List<Post> post) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
	this.post = post;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}


}
