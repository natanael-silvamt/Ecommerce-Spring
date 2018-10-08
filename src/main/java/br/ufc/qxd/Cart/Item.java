package br.ufc.qxd.Cart;

import br.ufc.qxd.Model.Product;

public class Item {
	private Product product;
	private Integer quantity;
	
	public Item() {}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}	
}
