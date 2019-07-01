package learning.project.supermarket.domain;

public class Inventory {

	private String id;
	private String name;
	private Integer qtyAvailable;
	private double priceEachItem;

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

	public Integer getQtyAvailable() {
		return qtyAvailable;
	}

	public void setQtyAvailable(Integer qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	public double getPriceEachItem() {
		return priceEachItem;
	}

	public void setPriceEachItem(double priceEachItem) {
		this.priceEachItem = priceEachItem;
	}

}
