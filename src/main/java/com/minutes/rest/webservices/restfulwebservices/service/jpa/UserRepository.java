package com.minutes.rest.webservices.restfulwebservices.service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minutes.rest.webservices.restfulwebservices.service.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
