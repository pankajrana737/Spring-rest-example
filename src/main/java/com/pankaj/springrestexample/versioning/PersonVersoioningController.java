package com.pankaj.springrestexample.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersoioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping("/v2/person")
	public PersonV2 personv2() {
		return new PersonV2("Bob"," Charlie");
	}

	// version using params
	//http://localhost:5000/person/param?version=1
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramv2() {
		return new PersonV2("Bob"," Charlie");
	}
	
	// version using headers
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("Bob Charlie");
	}
	// http://localhost:5000/person/param?headers
	// headername = X-API-VERSION, value=2
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2("Bob"," Charlie");
	}
	/// produce codee
	
	
	
	@GetMapping(value="/person/produces",produces="application/v1+json")
	public PersonV1 producesv1() {
		return new PersonV1("Bob Charlie");
	}

	//http://localhost:5000/person/produces
	//accept=application/v1+json

	@GetMapping(value="/person/produces",produces="application/v2+json")
	public PersonV2 producesv2() {
		return new PersonV2("Bob"," Charlie");
	}
}
