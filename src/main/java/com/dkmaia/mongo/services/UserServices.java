package com.dkmaia.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkmaia.mongo.doman.User;
import com.dkmaia.mongo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}

}
