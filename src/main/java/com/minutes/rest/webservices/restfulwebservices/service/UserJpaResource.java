package com.minutes.rest.webservices.restfulwebservices.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.minutes.rest.webservices.restfulwebservices.service.jpa.PostRepository;
import com.minutes.rest.webservices.restfulwebservices.service.jpa.UserRepository;
import com.minutes.rest.webservices.restfulwebservices.service.post.Post;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	UserDaoService userDaoService;
	UserRepository repository;
	PostRepository postRepository;
	public UserJpaResource(UserDaoService userDaoService,UserRepository repository
			,PostRepository postRepository) {
		super();
		this.userDaoService = userDaoService;
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/users/jpa")
	public List<User> findAllUser(){
		return repository.findAll();
	}
	
	@GetMapping("/users/jpa/{id}")
	public EntityModel<User> findById(@PathVariable Integer id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id "+id);
		}
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUser());
		entityModel.add(link.withRel("all-user"));
		return entityModel;
	}
	
	@PostMapping("/users/jpa")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		repository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/jpa/{id}")
	public void deleteById(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/users/jpa/{id}/posts")
	public List<Post> retrievePostById(@PathVariable Integer id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id" + id);
		}
		return user.get().getPost();
	}
	
	@PostMapping("/users/jpa/{id}/posts")
	public ResponseEntity<User> post(@Valid @RequestBody Post post,@PathVariable Integer id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id" + id);
		}
		post.setUser(user.get());
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("")
				.buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
