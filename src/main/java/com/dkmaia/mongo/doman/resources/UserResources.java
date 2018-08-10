package com.dkmaia.mongo.doman.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkmaia.mongo.doman.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User lucio = new User("1", "Lucio Maia", "lucio@live.com");
		User dowglas = new User("2", "Dowglas Maia", "lucio@live.com");
		User maria = new User("3", "Maria Natash", "lucio@live.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(lucio, dowglas, maria));

		return ResponseEntity.ok().body(list);
	}
}
