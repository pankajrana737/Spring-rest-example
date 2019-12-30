package com.pankaj.springrestexample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.pankaj.springrestexample.model.SampleBean;
import com.pankaj.springrestexample.utility.FilterBeanFileds;


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
	public  MappingJacksonValue getFilteredDataList(){
		List<SampleBean> data= new ArrayList<SampleBean>();
		
		data.add(new SampleBean("filed1", "filed2", "filed3", "filed41", "filed5"));
		data.add(new SampleBean("filed21", "filed2", "filed352", "filed42", "filed5"));
		data.add(new SampleBean("filed31", "filed26", "filed34", "filed44", "filed5"));
		data.add(new SampleBean("filed41", "filed25", "filed31", "filed46", "filed5"));
		data.add(new SampleBean("filed41", "filed25", "filed32", "filed48", "filed5"));
			
	
		return		  FilterBeanFileds.filterData(data,"myFilterName","filed2","filed1","filed5");
		
		
		
	}
	
	
	@GetMapping("/filtering1")
	public MappingJacksonValue getFilteredData(){
		SampleBean sampleBean = new SampleBean("filed1", "filed2", "filed3", "filed4", "filed5");
		List<SampleBean> data= new ArrayList<>();
		data.add(sampleBean);
		
				  
		return		  FilterBeanFileds.filterData(data,"myFilterName","filed1","filed3","filed4");
		
		
	}

	

}
