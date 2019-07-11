package learning.project.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learning.project.supermarket.domain.Customer;
import learning.project.supermarket.service.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = { "application/xml", "application/json" })
	public List<Customer> searchAllCustomersByItemName(@RequestParam(required = false) String itemName,
			@RequestParam(required = false) String lastName) {

		if (itemName != null)
			return service.searchCustomersByItemName(itemName);
		return service.searchCustomersByLastName(lastName);
	}
	
	@RequestMapping(method =  RequestMethod.POST, consumes = { "application/xml", "application/json" })
	public Customer onBoardCustomer(Customer customer) {
		return service.saveCustomer(customer);
	}
	


}
