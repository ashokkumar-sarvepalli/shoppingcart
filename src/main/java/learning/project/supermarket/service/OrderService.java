package learning.project.supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.project.supermarket.domain.Order;
import learning.project.supermarket.dto.OrderDto;
import learning.project.supermarket.repository.OrderRepository;
import learning.project.supermarket.transformer.OrderTransformer;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderTransformer transformer;
	
	
	public Order getById(String id) {
		
		OrderDto orderDto = repository.findById(id).orElseThrow();
		
		
	    
		Order order = transformer.transformOrderDtoTOOrder(orderDto);
		return order;
	}

}
