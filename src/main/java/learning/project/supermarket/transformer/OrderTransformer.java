package learning.project.supermarket.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import learning.project.supermarket.domain.Customer;
import learning.project.supermarket.domain.Item;
import learning.project.supermarket.domain.Order;
import learning.project.supermarket.dto.CustomerDto;
import learning.project.supermarket.dto.ItemDto;
import learning.project.supermarket.dto.OrderDto;

@Component
public class OrderTransformer {

	public Order transformOrderDtoTOOrder(OrderDto orderDto) {
		Order order = new Order();

		order.setOrderId(orderDto.getOrderId());
		order.setCustomer(transformCustomerDtoToCustomer(orderDto.getCustomer()));
		order.setItems(transformItemsDtoListToItemsList(orderDto.getItems()));
		order.setTotalAmount(orderDto.getTotalAmount());

		return order;
	}

	private List<Item> transformItemsDtoListToItemsList(List<ItemDto> itemDtoList) {

		if (!CollectionUtils.isEmpty(itemDtoList)) {
			return itemDtoList.stream().filter(itemDto -> itemDto != null)
					.map(itemDto -> transformItemsDtoToItems(itemDto)).collect(Collectors.toList());
		}

		return null;

	}

	private Item transformItemsDtoToItems(ItemDto itemDto) {
		Item item = new Item();
		item.setName(itemDto.getName());
		item.setPrice(itemDto.getPrice());
		item.setQty(itemDto.getQty());
		return item;
	}

	private Customer transformCustomerDtoToCustomer(CustomerDto customerDto) {
		
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		
		return customer;
	}

}
