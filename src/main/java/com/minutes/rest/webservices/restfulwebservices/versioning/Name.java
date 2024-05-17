package com.minutes.rest.webservices.restfulwebservices.versioning;

public class Name {
	String firstName;
	String secondName;

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public Name(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", secondName=" + secondName + "]";
	}
}
