package coding.example.ecommerce.controller;

import java.util.List;
import java.util.Map;

import coding.example.ecommerce.dto.Product;
import coding.example.ecommerce.entity.ProductEntity;
import coding.example.ecommerce.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.example.ecommerce.repos.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductRepository productRepository;
  private final IProductService productService;

  public ProductController(ProductRepository productRepository, IProductService productService) {
    this.productRepository = productRepository;
    this.productService = productService;
  }

  @GetMapping()
  public ResponseEntity<List<Product>> getAllProducts() {
    return this.productService.getAllProducts();
  }

  @GetMapping("/{itemNo}")
  public ResponseEntity<Product> getByProductItemNo(@PathVariable Long itemNo) {
    return this.productService.getByProductItemNo(itemNo);
  }

  @PostMapping("/add")
  public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
    return productRepository.save(productEntity);
  }

  @PutMapping("/{itemNo}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long itemNo,
                                               @RequestBody Product product) {
    return this.productService.updateProduct(itemNo, product);
  }

  @PostMapping("/delete")
  public ResponseEntity<Map<String, Boolean>> deleteProductList(@RequestBody List<Product> productList) {
    return this.productService.deleteProductList(productList);
  }

  @GetMapping("/brands")
  public ResponseEntity<List<String>> getBrands() {
    return this.productService.getAllBrands();
  }
}
