package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service                               //registrando a entidade para a injeção de
public class UserService {             //dependência em outra classe (UserResource)

	@Autowired                         //injeção de dependência -> a interface UserRepository
	private UserRepository repository; //não necessita da anotação @Repository para registro,
	                                   //porque ela herda propriedades da interface JPARepository,
	public List<User> findAll(){       //que já é nativamente registrada
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
