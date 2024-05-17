package com.minutes.rest.webservices.restfulwebservices.service.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minutes.rest.webservices.restfulwebservices.service.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue
	Integer id;
	String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
}
