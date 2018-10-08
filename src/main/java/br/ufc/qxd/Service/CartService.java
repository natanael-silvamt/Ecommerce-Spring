package br.ufc.qxd.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.ufc.qxd.Cart.*;
import br.ufc.qxd.Model.*;
import br.ufc.qxd.Repository.ClientRepository;
import br.ufc.qxd.Repository.PurchaseRepository;
import br.ufc.qxd.Repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public void addProduto(Product product) {
			product.setList_contains(true);
			Cart.list.add(product);
			Cart.utter += product.getPrice();			
	}
	
	public Product getById(Long id) {
		return this.productRepository.getOne(id);
	}
	
	public void remove_product(Long id) {
		for(int i = 0; i < Cart.list.size(); i++) {
			if(Cart.list.get(i).getId().equals(id)) {
				Cart.utter -= Cart.list.get(i).getPrice() * Cart.list.get(i).getQuantity();
				Cart.list.remove(i);
			}
		}
	}
	
	public void buy_product() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;		
		Client client = this.clientRepository.findByLogin(user.getUsername());
		
		for(Product prod : Cart.list) {
			if(prod.isList_contains()) {
				Purchase purchase = new Purchase(client.getId(), prod.getId(), prod.getQuantity(), (double) (prod.getPrice() * prod.getQuantity()));
				this.purchaseRepository.save(purchase);
			}
		}
		deleteList();
	}
	
	public List<Purchases_Historic> purchases_historic(){
		List<Purchase> purchases = new ArrayList<>();
		List<Purchases_Historic> historicoCompras = new ArrayList<>();
		purchases = this.purchaseRepository.findAll();
		
		for(Purchase purch : purchases) {
			Client client = this.clientRepository.getOne(purch.getUser_id());
			Product product = this.productRepository.getOne(purch.getProduct_id());
			Purchases_Historic historic = new Purchases_Historic(purch.getPurchase_id(), client.getName(), product.getName(), purch.getQuantity(), purch.getValue());
			historicoCompras.add(historic);
		}
		return historicoCompras;
	}
	
	private void deleteList() {
		Cart.list.clear();
		Cart.utter = 0.0;
	}
}
