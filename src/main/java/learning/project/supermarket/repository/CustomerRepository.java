package learning.project.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.project.supermarket.dto.CustomerDto;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, String>{

}
