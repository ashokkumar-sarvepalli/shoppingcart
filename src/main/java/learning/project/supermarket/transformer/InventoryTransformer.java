package learning.project.supermarket.transformer;

import org.springframework.stereotype.Component;

import learning.project.supermarket.domain.Inventory;
import learning.project.supermarket.dto.InventoryDto;

@Component
public class InventoryTransformer {

	
	public Inventory transformToInventroy(InventoryDto inventoryDto) {
		Inventory inventory = new Inventory();
		inventory.setId(inventoryDto.getId());
		inventory.setName(inventoryDto.getName());
		inventory.setPriceEachItem(inventoryDto.getPrice());
		inventory.setQtyAvailable(inventoryDto.getQuantity());
		return inventory;
	}
}
