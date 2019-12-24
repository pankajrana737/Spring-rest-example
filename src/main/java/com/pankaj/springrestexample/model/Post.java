package com.pankaj.springrestexample.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Post {
private Date postingDate;

private String tittle;
private String psotMessgae;
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
public String getPsotMessgae() {
	return psotMessgae;
}
public void setPsotMessgae(String psotMessgae) {
	this.psotMessgae = psotMessgae;
}
public Post(Date postingDate, String tittle, String psotMessgae) {
	super();
	this.postingDate = postingDate;
	this.tittle = tittle;
	this.psotMessgae = psotMessgae;
}


}
