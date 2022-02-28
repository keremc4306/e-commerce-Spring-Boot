package coding.example.ecommerce.service;

import coding.example.ecommerce.dto.Product;
import coding.example.ecommerce.entity.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IProductService {

  ResponseEntity<List<Product>> getAllProducts();
  ResponseEntity<Product> getByProductItemNo(Long itemNo);
  ResponseEntity<Product> updateProduct(Long itemNo, Product product);
  ResponseEntity<List<String>> getAllBrands();
  ResponseEntity<Map<String, Boolean>> deleteProductList(List<Product> productList);
}
