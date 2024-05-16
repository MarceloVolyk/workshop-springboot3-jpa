package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service                               //registrando a entidade para a injeção de
public class OrderService {             //dependência em outra classe (OrderResource)

	@Autowired                         //injeção de dependência -> a interface OrderRepository
	private OrderRepository repository; //não necessita da anotação @Repository para registro,
	                                   //porque ela herda propriedades da interface JPARepository,
	public List<Order> findAll(){       //que já é nativamente registrada
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
