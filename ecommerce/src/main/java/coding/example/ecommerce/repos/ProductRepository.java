package coding.example.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coding.example.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
