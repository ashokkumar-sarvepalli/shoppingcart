package learning.project.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learning.project.supermarket.dto.CustomerDto;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, String> {

	// jpa standard
	public List<CustomerDto> findByLastName(String lastName);

	// hql
	@Query("select c from CustomerDto c join c.orders o join o.items i where i.name = :itemName")
	public List<CustomerDto> findAllTheCustomersByItemName(String itemName);

	// hql multiple selections with object array return type
	@Query("select c.firstName, c.lastName ,i.name from CustomerDto c join c.orders o join o.items i where i.name = :itemName")
	public List<Object[]> findAllCustomerAndItemInformation(String itemName);

	// native sql
	@Query(value = "SELECT NAME, SUM(QTY) FROM supermarket.ITEM GROUP BY NAME", nativeQuery = true)
	public Object[][] findTotalSalesByItemName();

}
