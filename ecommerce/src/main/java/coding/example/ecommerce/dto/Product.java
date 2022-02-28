package coding.example.ecommerce.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
public class Product {
  private Long itemNo;
  private String brandName;
  private String productName;
  private Long ram;
  private Long ssd;
  private BigDecimal price;
  private Long numOfStock;
}
