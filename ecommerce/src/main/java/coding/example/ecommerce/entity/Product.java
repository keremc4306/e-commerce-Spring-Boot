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

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_no")
	private int itemNo;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@Column(name = "pro_name")
	private String proName;
	
	@Column(name = "ram")
	private int ram;
	
	@Column(name = "ssd")
	private int ssd;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "num_of_stock")
	private int numOfStock;
}
