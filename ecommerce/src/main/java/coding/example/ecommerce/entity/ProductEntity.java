package coding.example.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_no")
	private Long itemNo;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@Column(name = "pro_name")
	private String productName;
	
	@Column(name = "ram")
	private Long ram;
	
	@Column(name = "ssd")
	private Long ssd;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "num_of_stock")
	private Long numOfStock;
}
