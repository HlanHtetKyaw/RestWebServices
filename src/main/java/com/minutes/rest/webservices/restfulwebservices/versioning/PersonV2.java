package com.minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {
	Name name;
	PersonV2(Name name){
		super();
		this.name = name;
	}
	public Name getName() {
		return name;
	}
	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
	
}
