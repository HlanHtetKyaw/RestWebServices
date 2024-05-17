package com.minutes.rest.webservices.restfulwebservices.error;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.ObjectError;

public class ErrorDetails {
	LocalDateTime date;
	String message;
	List<ObjectError> errors;
	String description;
	public ErrorDetails(LocalDateTime date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}
	public ErrorDetails(LocalDateTime now, List<ObjectError> errors, String description2) {
		// TODO Auto-generated constructor stub
		super();
		this.date = now;
		this.errors = errors;
		this.description = description2;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
	public List<ObjectError> getErrors(){
		return errors;
	}
	@Override
	public String toString() {
		return "ErrorDetails [date=" + date + ", message=" + message + ", description=" + description + "]";
	}
}
