package learning.project.supermarket.service;

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

	public List<Customer> searchCustomersByItemName(String itemName) {
		List<Customer> customerList =  null;

		List<CustomerDto> customerDtoList = repository.findAll();

		if (!CollectionUtils.isEmpty(customerDtoList)) {

			customerList =  customerDtoList.stream()
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
				.filter(order -> !CollectionUtils.isEmpty(order.getItems()))
				.flatMap(order -> order.getItems().stream())
				.filter(item -> item.getName().equalsIgnoreCase(itemName))
				.mapToInt(item -> item.getQty()).sum();
		
		System.out.println("Total Sales of a particular item "+sum);

		return customerList;
	}

	public Customer convertCustomerDtoToCustomer(CustomerDto customerDto) {

		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPhoneNumber(customerDto.getPhoneNumber());

		return customer;
	}
}
