package com.minutes.rest.webservices.restfulwebservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int idCount = 0;
	static {
		users.add(new User(++idCount,"Mao",LocalDate.now().minusYears(30)));
		users.add(new User(++idCount,"Kham",LocalDate.now().minusYears(25)));
		users.add(new User(++idCount,"Linn",LocalDate.now().minusYears(10)));
	}
	public List<User> findAllUser(){
		return users;
	}
	public User findById(Integer id) {
		Predicate<? super User> predicate = user->user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	public void saveUser(User user) {
		user.setId(++idCount);
		users.add(user);
	}
	public void deleteById(Integer id) {
		Predicate<?super User> predicate = user->user.getId().equals(id);
		users.removeIf(predicate);
	}
}
