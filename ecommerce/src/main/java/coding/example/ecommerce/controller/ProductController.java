package coding.example.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.example.ecommerce.entity.Product;
import coding.example.ecommerce.exception.ResourceNotFoundException;
import coding.example.ecommerce.repos.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping()
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/{itemNo}")
	public Product getByProductItemNo(@PathVariable int itemNo) {
		return productRepository.findById(itemNo)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with "
						+ "id :" + itemNo));
	}
	
	@PostMapping("/add")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/{itemNo}")
    public ResponseEntity<Product> updateProduct(@PathVariable int itemNo, 
    		@RequestBody Product productDetails){
        Product product = productRepository.findById(itemNo)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with "
                		+ "item no :" + itemNo));

        product.setBrandName(productDetails.getBrandName());
        product.setProName(productDetails.getProName());
        product.setRam(productDetails.getRam());
        product.setSsd(productDetails.getSsd());
        product.setPrice(productDetails.getPrice());
        product.setNumOfStock(productDetails.getNumOfStock());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
	
	@PostMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> 
			deleteProduct(@RequestBody List<Product> products) {
        productRepository.deleteAll(products);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
	
	@GetMapping("/brands")
	public List<String> getBrands() {
		return productRepository.getAllBrands();
	}
}
