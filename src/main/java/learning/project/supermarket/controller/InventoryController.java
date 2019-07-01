package learning.project.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import learning.project.supermarket.domain.Inventory;
import learning.project.supermarket.service.InventoryService;

@RestController
@RequestMapping(value="/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.GET)
	public Inventory searchInventoryById(@PathVariable("id") String id) {
		return service.getById(id);
	}

}
