package com.dkmaia.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dkmaia.mongo.doman.Post;
import com.dkmaia.mongo.doman.User;
import com.dkmaia.mongo.dto.AuthorDTO;
import com.dkmaia.mongo.repository.PostRepository;
import com.dkmaia.mongo.repository.UserRepository;

@Configuration
public class InstantionRun implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll(); // limpando as Coleções
		postRepository.deleteAll();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		User Dowglas = new User(null, "Dowglas Maia", "dkmaia@gmail.com");
		User Kayron = new User(null, "Kayron Maia", "kkmaia@gmail.com");
		User Kamilly = new User(null, "Kamilly Maia", "kamilly@gmail.com");
		userRepository.saveAll(Arrays.asList(Dowglas, Kayron, Kamilly)); // Salvar Os Usuarios

		//***
		Post post1 = new Post(new AuthorDTO(Dowglas), null, sdf.parse("10/05/2015"), "Partiu Porto-PT !",
				"Estou Mundando Para Porto!");
		Post post2 = new Post(new AuthorDTO(Dowglas), null, sdf.parse("20/07/2015"), "Aqui é só Sucesso !",
				"Apoixonei por Porto, Cidade Maravilhosa!");

		postRepository.saveAll(Arrays.asList(post1, post2)); // Salvar Os Posts

	}

}
