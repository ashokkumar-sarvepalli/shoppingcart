package learning.project.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.project.supermarket.dto.OrderDto;

public interface OrderRepository extends JpaRepository<OrderDto, String>{

}
