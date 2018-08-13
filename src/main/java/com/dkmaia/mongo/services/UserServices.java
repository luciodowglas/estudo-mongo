package com.dkmaia.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkmaia.mongo.doman.User;
import com.dkmaia.mongo.dto.UserDTO;
import com.dkmaia.mongo.repository.UserRepository;
import com.dkmaia.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepo;

	// Listar Todos os Usuarios Usando o DataJPA
	public List<User> findAll() {
		return userRepo.findAll();

	}

	// Localizar Usuario Pelo ID
	public User findById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado!"));
	}

	// Metodo Inserir
	public User insert(User obj) {
		return userRepo.insert(obj);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
