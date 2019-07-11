package learning.project.supermarket.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import learning.project.supermarket.domain.Customer;
import learning.project.supermarket.dto.CustomerDto;
import learning.project.supermarket.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	// java 8 way of iterating things
	public List<Customer> searchCustomersByItemNameJava8(String itemName) {

		List<Customer> customerList = null;

		List<CustomerDto> customerDtoList = repository.findAll();

		if (!CollectionUtils.isEmpty(customerDtoList)) {

			customerList = customerDtoList.stream()
					.filter(customer -> customer.getOrders() != null && customer.getOrders().stream()
							.anyMatch(order -> order != null && order.getItems() != null
									&& order.getItems().stream()
											.anyMatch(item -> item != null && item.getName() != null
													&& item.getName().equalsIgnoreCase(itemName))))
					.map(customerDto -> convertCustomerDtoToCustomer(customerDto)).collect(Collectors.toList());
		}

		System.out.println("Total Sales of a particular item");

		int sum = customerDtoList.stream().filter(customer -> !CollectionUtils.isEmpty(customer.getOrders()))
				.flatMap(customer -> customer.getOrders().stream())
				.filter(order -> !CollectionUtils.isEmpty(order.getItems())).flatMap(order -> order.getItems().stream())
				.filter(item -> item.getName().equalsIgnoreCase(itemName)).mapToInt(item -> item.getQty()).sum();

		System.out.println("Total Sales of a particular item " + sum);

		return customerList;

	}

	// Jpa way of findbymethod
	public List<Customer> searchCustomersByLastName(String lastName) {

		List<CustomerDto> customerDtoList = repository.findByLastName(lastName);

		return customerDtoList.stream().map(customerDto -> convertCustomerDtoToCustomer(customerDto))
				.collect(Collectors.toList());

	}

	public List<Customer> searchCustomersByItemName(String itemName) {
		
		// hql query normal
		List<CustomerDto> customerDtoList = repository.findAllTheCustomersByItemName(itemName);
		
		// hql query jpa object array combining multiple tables
		List<Object[]> result = repository.findAllCustomerAndItemInformation(itemName);
		
		for(Object[] obj : result) {
			System.out.println("first name "+(String) obj[0]);
			System.out.println("last name "+(String) obj[1]);
			System.out.println("item name "+(String) obj[2]);
		}
		
		//native query
		
		Object[][] salesResult = repository.findTotalSalesByItemName();
		
		for(Object [] obj : salesResult) {
			System.out.println("ItemName "+(String)obj[0]);
			System.out.println("Qty "+(BigDecimal)obj[1]);
		}
		
		
		// returning normal hql query.. the above are just printing purpose
		return customerDtoList.stream().map(customerDto -> convertCustomerDtoToCustomer(customerDto)).collect(Collectors.toList());

		
	}

	public Customer convertCustomerDtoToCustomer(CustomerDto customerDto) {

		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPhoneNumber(customerDto.getPhoneNumber());

		return customer;
	}

	public Customer saveCustomer(Customer customer) {
		CustomerDto customerDto = convertCustomerToCustomerDto(customer);
		CustomerDto savedCustomerDto = repository.save(customerDto);
		return convertCustomerDtoToCustomer(savedCustomerDto);
	}

	private CustomerDto convertCustomerToCustomerDto(Customer customer) {

		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setPhoneNumber(customer.getPhoneNumber());

		return customerDto;
	}
}
