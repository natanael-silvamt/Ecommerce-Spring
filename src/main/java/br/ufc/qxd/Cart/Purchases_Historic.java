package br.ufc.qxd.Cart;

public class Purchases_Historic {

	private Long purchase_id;
	private String user;
	private String product;
	private Integer quantity;
	private Double value;
	
	public Purchases_Historic() {}
	
	public Purchases_Historic(Long purchase_id, String user, String product, Integer quantity, Double value) {
		this.purchase_id = purchase_id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.value = value;
	}

	public Long getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(Long purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
