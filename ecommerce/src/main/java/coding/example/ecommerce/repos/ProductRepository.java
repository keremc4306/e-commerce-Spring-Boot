package coding.example.ecommerce.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coding.example.ecommerce.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	@Query("select distinct p.brandName from ProductEntity p")
	List<String> getAllBrands();
}
