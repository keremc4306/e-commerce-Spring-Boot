package coding.example.ecommerce.service;

import java.util.List;

import coding.example.ecommerce.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.example.ecommerce.repos.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ProductEntity createProduct(ProductEntity productEntity) {
		productRepository.save(productEntity);
		return productEntity;
	}
	
	public List<ProductEntity> viewProduct(ProductEntity productEntity) {
		return productRepository.findAll();
	}
	
	public ProductEntity deleteProduct(ProductEntity productEntity) {
		productRepository.delete(productEntity);
		return productEntity;
	}
}
