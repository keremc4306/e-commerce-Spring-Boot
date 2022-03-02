package coding.example.ecommerce.impl;

import coding.example.ecommerce.dto.Product;
import coding.example.ecommerce.entity.ProductEntity;
import coding.example.ecommerce.exception.ResourceNotFoundException;
import coding.example.ecommerce.mapper.ProductMapper;
import coding.example.ecommerce.message.MessageUtilityImpl;
import coding.example.ecommerce.repository.ProductRepository;
import coding.example.ecommerce.service.IProductService;
import coding.example.ecommerce.type.EnumDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Override
  public ResponseEntity<List<Product>> getAllProducts() {
    List<ProductEntity> productEntityList = this.productRepository.findAll();

    if (productEntityList.isEmpty())
      return ResponseEntity.noContent().build();

    return ResponseEntity.ok(this.productMapper.toDtoList(productEntityList));
  }

  @Override
  public ResponseEntity<Product> getByProductItemNo(Long itemNo) {
    ProductEntity productEntity = this.productRepository.findById(itemNo)
        .orElseThrow(() -> new ResourceNotFoundException(MessageUtilityImpl.getMessage("productEntity.notFound.withItemNo", itemNo)));

    return ResponseEntity.ok(this.productMapper.toDto(productEntity));
  }

  @Override
  public ResponseEntity<Product> updateProduct(Long itemNo, Product product) {
    ProductEntity productEntity = this.productRepository.findById(itemNo)
        .orElseThrow(() -> new ResourceNotFoundException(MessageUtilityImpl.getMessage("productEntity.notFound.withItemNo", itemNo)));

    this.generateUpdatedProductEntity(productEntity, product);

    return ResponseEntity.ok(this.productMapper.toDto(this.productRepository.save(productEntity)));
  }

  @Override
  public ResponseEntity<List<String>> getAllBrands() {
    List<String> brands = this.productRepository.getAllBrands();

    if (brands.isEmpty())
      return ResponseEntity.noContent().build();

    return ResponseEntity.ok(brands);
  }

  @Override
  public ResponseEntity<Map<String, Boolean>> deleteProductList(List<Product> productList) {
    this.productRepository.deleteAll(this.productMapper.toEntityList(productList));
    return ResponseEntity.ok(Map.of(EnumDefinition.ProductStatus.DELETED.getCode(), true));
  }

  private void generateUpdatedProductEntity(ProductEntity productEntity, Product product) {
    if (Objects.nonNull(product.getBrandName()))
      productEntity.setBrandName(product.getBrandName());
    if (Objects.nonNull(product.getProductName()))
      productEntity.setProductName(product.getProductName());
    if (Objects.nonNull(product.getRam()))
      productEntity.setRam(product.getRam());
    if (Objects.nonNull(product.getSsd()))
      productEntity.setSsd(product.getSsd());
    if (Objects.nonNull(product.getPrice()))
      productEntity.setPrice(product.getPrice());
    if (Objects.nonNull(product.getNumOfStock()))
      productEntity.setNumOfStock(product.getNumOfStock());
  }
}
