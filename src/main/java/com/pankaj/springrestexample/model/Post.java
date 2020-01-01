package com.pankaj.springrestexample.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
private Integer id;	
private Date postingDate;

private String tittle;
private String postMessage;

@ManyToOne(fetch = FetchType.LAZY)
private User user;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Date getPostingDate() {
	return postingDate;
}

public void setPostingDate(Date postingDate) {
	this.postingDate = postingDate;
}

public String getTittle() {
	return tittle;
}

public void setTittle(String tittle) {
	this.tittle = tittle;
}

public String getPostMessage() {
	return postMessage;
}

public void setPostMessage(String postMessage) {
	this.postMessage = postMessage;
}

@JsonIgnore
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Post() {
	super();
	// TODO Auto-generated constructor stub
}

public Post(Integer id, Date postingDate, String tittle, String postMessage) {
	super();
	this.id = id;
	this.postingDate = postingDate;
	this.tittle = tittle;
	this.postMessage = postMessage;
	//this.user = user;
}

@Override
public String toString() {
	return "JpaPost [id=" + id + ", postingDate=" + postingDate + ", tittle=" + tittle + ", postMessage=" + postMessage
			+ "]";
}


}
