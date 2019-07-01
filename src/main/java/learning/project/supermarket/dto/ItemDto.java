package learning.project.supermarket.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ITEM")
public class ItemDto {
	
	
	@Column(name="ID")
	@Id
	private String Id;
	
	@Column(name="ITEM_ID")
	private String inventoryId;

	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="QTY")
	private int qty;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ORDER_ID", nullable=false)
	private OrderDto order;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}


	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	
	
	
	
	
	
	
	
}
