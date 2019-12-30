package com.pankaj.springrestexample.utility;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class FilterBeanFileds {

	
	public static MappingJacksonValue filterData(List beans,String myFilterName,String ...fileds) {
		
		SimpleBeanPropertyFilter filterFields=
				  SimpleBeanPropertyFilter.filterOutAllExcept(fileds);
				  FilterProvider filterFewItem= new
				  SimpleFilterProvider().addFilter(myFilterName,filterFields); 
				  
				  MappingJacksonValue mapping= new		 MappingJacksonValue(beans);
				  mapping.setFilters(filterFewItem);
		
				return mapping;
	}
}
