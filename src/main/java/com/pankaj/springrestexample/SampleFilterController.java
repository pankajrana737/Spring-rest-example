package com.pankaj.springrestexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.pankaj.springrestexample.model.SampleBean;


@RestController
public class SampleFilterController {
	
	
	
	@GetMapping("/without-filtering")
	public List<SampleBean> getAllBeanData(){
		List<SampleBean> data= new ArrayList<SampleBean>();
		data.add(new SampleBean("filed1", "filed2", "filed3", "filed4", "filed5"));
		data.add(new SampleBean("filed11", "filed22", "filed33", "filed44", "filed55"));
		return data;
		
	}
	
	// send fild1 and filed 4 only
	
	@GetMapping("/listfiltering1")
	public List< MappingJacksonValue> getFilteredDataList(){
		List<SampleBean> data= new ArrayList<SampleBean>();
		
		List<MappingJacksonValue> resultdata= new ArrayList<MappingJacksonValue>();
		data.add(new SampleBean("filed1", "filed2", "filed3", "filed41", "filed5"));
		data.add(new SampleBean("filed21", "filed2", "filed3", "filed42", "filed5"));
		data.add(new SampleBean("filed31", "filed26", "filed3", "filed44", "filed5"));
		data.add(new SampleBean("filed41", "filed25", "filed3", "filed46", "filed5"));
		data.add(new SampleBean("filed41", "filed25", "filed3", "filed48", "filed5"));
		
		  SimpleBeanPropertyFilter filter=
				  SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed4");
		
		  FilterProvider filterFewItem= new
				  SimpleFilterProvider().addFilter("myFilterName",filter); 
				  for(SampleBean myBean: data) {
					
							
							  MappingJacksonValue mapping;
					mapping= new MappingJacksonValue(myBean);
					mapping.setFilters(filterFewItem);
					  resultdata.add(mapping);				
					  }
				 
		
				return resultdata;
		
		
		
	}
	
	
	@GetMapping("/filtering1")
	public MappingJacksonValue getFilteredData(){
		SampleBean sampleBean = new SampleBean("filed1", "filed2", "filed3", "filed4", "filed5");
		
		
		SimpleBeanPropertyFilter filter=
				  SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed4");
				  FilterProvider filterFewItem= new
				  SimpleFilterProvider().addFilter("myFilterName",filter); 
				  
				  MappingJacksonValue mapping= new		 MappingJacksonValue(sampleBean);
				  mapping.setFilters(filterFewItem);
		
				return mapping;
		
		
		
	}

}
