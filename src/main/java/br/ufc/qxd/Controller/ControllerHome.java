package br.ufc.qxd.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.qxd.Model.Product;
import br.ufc.qxd.Service.ServiceProduct;

@Controller
public class ControllerHome {
	
	@Autowired
	private ServiceProduct serviceProduct;
	
	@GetMapping("/")
	public ModelAndView inicio() {
		List<Product> products = new ArrayList<>();
		if(this.serviceProduct.getProducts().size() > 3) {
			for(int i = 0; i < 3; i++)
				products.add(this.serviceProduct.getProducts().get(i));
		}else {
			products = this.serviceProduct.getProducts();
		}
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("allProdutos", products);
		return mv;
	}

}
