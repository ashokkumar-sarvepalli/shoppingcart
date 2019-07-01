package learning.project.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learning.project.supermarket.domain.Customer;
import learning.project.supermarket.service.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	
	@GetMapping
	public List<Customer> searchAllCustomersByItemName(@RequestParam String itemName) {
		return service.searchCustomersByItemName(itemName);
	}


}
