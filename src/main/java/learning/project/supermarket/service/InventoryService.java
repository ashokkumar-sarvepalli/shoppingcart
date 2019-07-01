package learning.project.supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.project.supermarket.domain.Inventory;
import learning.project.supermarket.dto.InventoryDto;
import learning.project.supermarket.repository.InventoryRepository;
import learning.project.supermarket.transformer.InventoryTransformer;

@Service
public class InventoryService {

	
	@Autowired
	private InventoryRepository repository;
	
	@Autowired
	private InventoryTransformer transformer;
	
	public Inventory getById(String id) {
		
		InventoryDto returnedDto = repository.getOne(id);
		Inventory inventory = transformer.transformToInventroy(returnedDto);
		
		return inventory;
	}

	
	
}
