package br.ufc.qxd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.qxd.Model.Product;
import br.ufc.qxd.Service.ServiceProduct;

@Controller
@RequestMapping("/produto")
public class ControllerProduct {
	
	@Autowired
	private ServiceProduct serviceProduct;

	@RequestMapping("/cadastro")
	public ModelAndView product_registration() {
		ModelAndView mv = new ModelAndView("cadastro_produto");
		mv.addObject("produto", new Product());
		return mv;
	}

	@PostMapping("/salvarProduto")
	public ModelAndView save_product(Product product, @RequestParam(value="foto") MultipartFile image) {
		this.serviceProduct.AddProduto(product, image);
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}

	@GetMapping("/listarProdutos")
	public ModelAndView list_products() {
		List<Product> products = this.serviceProduct.getProducts();
		ModelAndView mv = new ModelAndView("Produtos");
		mv.addObject("allProdutos", products);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView upgrade_product(@PathVariable Long id) {
		Product product = this.serviceProduct.getById(id);
		ModelAndView mv = new ModelAndView("cadastro_produto");
		mv.addObject("produto", product);
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView delete_product(@PathVariable Long id) {
		this.serviceProduct.remove_product(id);
		ModelAndView mv = new ModelAndView("redirect:/produto/listarProdutos");
		return mv;
	}
}
