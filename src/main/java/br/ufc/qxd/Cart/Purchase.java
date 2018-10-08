package br.ufc.qxd.Cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchase_id;
	
	private Long user_id;
	private Long product_id;
	private Integer quantity;
	private Double value;
	
	public Purchase() {}
	
	public Purchase(Long user_id, Long product_id, Integer quantity, Double value) {
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.value = value;
	}

	public Long getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(Long purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
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
