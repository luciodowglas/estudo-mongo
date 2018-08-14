package com.dkmaia.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkmaia.mongo.doman.Post;
import com.dkmaia.mongo.repository.PostRepository;
import com.dkmaia.mongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepository repository;

	// Localizar posts Pelo ID
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado!"));
	}

	public List<Post> findAll() {
		return repository.findAll();
	}

}
