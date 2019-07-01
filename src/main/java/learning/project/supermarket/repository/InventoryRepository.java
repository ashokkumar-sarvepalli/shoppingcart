package learning.project.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.project.supermarket.dto.InventoryDto;

public interface InventoryRepository extends JpaRepository<InventoryDto, String> {

}
