package br.ufc.qxd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.qxd.Model.Product;
import br.ufc.qxd.Repository.ProductRepository;
import br.ufc.qxd.Util.SaveImage;


@Service
public class ServiceProduct {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void AddProduto(Product product, MultipartFile image) {
		String path = "/img/" + product.getName() + ".png";
		product.setImage(path);
		SaveImage.save_image(path, image);
		this.productRepository.save(product);
	}
	
	public List<Product> getProducts(){
		return this.productRepository.findAll();
	}
	
	public void remove_product(Long id) {
		Product product = this.productRepository.getOne(id);
		SaveImage.delete_image("" + product.getImage());
		this.productRepository.deleteById(id);
	}
	
	public Product getById(Long id) {
		return this.productRepository.getOne(id);
	}
}
