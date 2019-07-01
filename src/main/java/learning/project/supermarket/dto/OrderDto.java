package learning.project.supermarket.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "ORDER_INFO")
public class OrderDto {

	@Id
	@Column(name = "ORDER_ID")
	private String orderId;

	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUST_ID", nullable=false)
	private CustomerDto customer;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="order")
	private List<ItemDto> items;
	
	
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	
	

}
