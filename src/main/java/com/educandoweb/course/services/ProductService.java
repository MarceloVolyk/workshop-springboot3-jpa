package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service                               //registrando a entidade para a injeção de
public class ProductService {             //dependência em outra classe (ProductResource)

	@Autowired                         //injeção de dependência -> a interface ProductRepository
	private ProductRepository repository; //não necessita da anotação @Repository para registro,
	                                   //porque ela herda propriedades da interface JPARepository,
	public List<Product> findAll(){       //que já é nativamente registrada
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
