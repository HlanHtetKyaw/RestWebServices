package com.minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {
	String name;

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
