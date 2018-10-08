package br.ufc.qxd.Cart;

import java.util.*;

import br.ufc.qxd.Model.Product;


public class Cart {
	public List<Item> itens = new ArrayList<>();
	public static List<Product> list = new ArrayList<>();
	public static Double utter = 0.0;
	
	public Cart() {}
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public static List<Product> getList() {
		return list;
	}
	public static void setList(List<Product> list) {
		Cart.list = list;
	}
	public static Double getUtter() {
		return utter;
	}
	public static void setUtter(Double utter) {
		Cart.utter = utter;
	}
}
