package com.minutes.rest.webservices.restfulwebservices.service.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minutes.rest.webservices.restfulwebservices.service.post.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
