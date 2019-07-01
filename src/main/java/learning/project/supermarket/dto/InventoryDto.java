package learning.project.supermarket.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "INVENTORY")
public class InventoryDto {

	@Column(name="ID")
	@Id
	private String id;

	@Column(name="NAME")
	private String name;

	@Column(name="QTY")
	private Integer quantity;

	@Column(name="PRICE")
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
