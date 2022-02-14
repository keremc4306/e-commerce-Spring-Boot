package coding.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.example.ecommerce.entity.Product;
import coding.example.ecommerce.repos.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	public List<Product> viewProduct(Product product) {
		return productRepository.findAll();
	}
	
	public Product deleteProduct(Product product) {
		productRepository.delete(product);
		return product;
	}
}
