package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service                                     //registrando a entidade para a injeção de
public class CategoryService {               //dependência em outra classe (CategoryResource)

	@Autowired                               //injeção de dependência -> a interface CategoryRepository
	private CategoryRepository repository;   //não necessita da anotação @Repository para registro,
	                                         //porque ela herda propriedades da interface JPARepository,
	public List<Category> findAll(){         //que já é nativamente registrada
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
