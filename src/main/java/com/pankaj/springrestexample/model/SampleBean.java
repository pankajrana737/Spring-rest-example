package com.pankaj.springrestexample.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;
// used in samplefilter controller
// json filter is argument of simpleFilterprovider constructor
@JsonFilter(value="myFilterName")


public class SampleBean {
	
	private String filed1;
	
	
	private String filed2;
	private String filed3;
	private String filed4;
	private String filed5;
	public SampleBean(String filed1, String filed2, String filed3, String filed4, String filed5) {
		super();
		this.filed1 = filed1;
		this.filed2 = filed2;
		this.filed3 = filed3;
		this.filed4 = filed4;
		this.filed5 = filed5;
	}
	@Override
	public String toString() {
		return "SampleBean [filed1=" + filed1 + ", filed2=" + filed2 + ", filed3=" + filed3 + ", filed4=" + filed4
				+ ", filed5=" + filed5 + "]";
	}
	public String getFiled1() {
		return filed1;
	}
	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	public String getFiled3() {
		return filed3;
	}
	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}
	public String getFiled4() {
		return filed4;
	}
	public void setFiled4(String filed4) {
		this.filed4 = filed4;
	}
	public String getFiled5() {
		return filed5;
	}
	public void setFiled5(String filed5) {
		this.filed5 = filed5;
	}
	
	

		
	

}
