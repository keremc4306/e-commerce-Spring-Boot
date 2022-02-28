package coding.example.ecommerce.mapper;

import coding.example.ecommerce.dto.Product;
import coding.example.ecommerce.entity.ProductEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  Product toDto(ProductEntity productEntity);

  @Mapping(target = "itemNo", ignore = true)
  ProductEntity toEntity(Product product);

  List<Product> toDtoList(List<ProductEntity> productEntityList);

  List<ProductEntity> toEntityList(List<Product> productList);

  @AfterMapping
  default void setEntityId(Product product, @MappingTarget ProductEntity productEntity) {
    if(Objects.nonNull(product.getItemNo()))
      productEntity.setItemNo(product.getItemNo());
  }
}
