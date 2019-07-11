package learning.project.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import learning.project.supermarket.domain.Order;
import learning.project.supermarket.service.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderController {

	
	@Autowired
	private OrderService service;
	
	
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.GET , produces = { "application/json", "application/xml" })
	public Order searchByOrderId(@PathVariable("id") String id) {
		return service.getById(id);
	}
}
