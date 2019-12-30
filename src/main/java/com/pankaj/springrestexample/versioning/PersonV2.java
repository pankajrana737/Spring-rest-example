package com.pankaj.springrestexample.versioning;

public class PersonV2 {
	String firstName;
	String LastName;
	public PersonV2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}
	public PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	

}
