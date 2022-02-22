package coding.example.ecommerce.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coding.example.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select distinct p.brandName from Product p")
	List<String> getAllBrands();
}
