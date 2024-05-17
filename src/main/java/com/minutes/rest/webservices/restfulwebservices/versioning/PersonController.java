package com.minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping("/v1/person")
	private PersonV1 v1Person() {
		return new PersonV1("Hlan Htet");
	}
	
	@GetMapping("/v2/person")
	private PersonV2 v2Person() {
		return new PersonV2(new Name("Hlan","Htet"));
	}
	
	@GetMapping(value="/person",params="version=1")
	private PersonV1 v1PersonParam() {
		return new PersonV1("Hlan Htet");
	}
	
	@GetMapping(value="/person",params="version=2")
	private PersonV2 v2PersonParam() {
		return new PersonV2(new Name("Hlan","Htet"));
	}
}
