package br.ufc.qxd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.qxd.Cart.*;
import br.ufc.qxd.Service.CartService;
import br.ufc.qxd.Model.*;

@Controller
@RequestMapping("/carrinho")
public class ControllerCart {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addProduto/{id}")
	public ModelAndView addItem(@PathVariable Long id) {
		Product product = this.cartService.getById(id);
		ModelAndView mv = new ModelAndView("redirect:/");

		for(Product product_list : Cart.list) {
			if(product_list.getId().equals(product.getId())) {
				product_list.setQuantity(product_list.getQuantity() + 1);
				Cart.utter += product_list.getPrice();
				return mv;
			}
		}
		this.cartService.addProduto(product);		
		return mv;
	}
	
	@GetMapping("/visualizar")
	public ModelAndView visualize() {
		ModelAndView mv = new ModelAndView("carrinho");
		mv.addObject("listProdutos", Cart.list);
		mv.addObject("valorTotal", Cart.utter);
		return mv;
	}
	
	@RequestMapping("/removerProduto/{id}")
	public ModelAndView remove(@PathVariable Long id) {
		this.cartService.remove_product(id);
		ModelAndView mv = new ModelAndView("redirect:/carrinho/visualizar");		
		return mv;
	}
	
	@RequestMapping("/comprar")
	public ModelAndView purchase() {
		this.cartService.buy_product();		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	
	@RequestMapping("/historicoCompras")
	public ModelAndView historic() {
		ModelAndView mv = new ModelAndView("historico_compras");
		mv.addObject("allCompras", this.cartService.purchases_historic());
		return mv;
	}

}
