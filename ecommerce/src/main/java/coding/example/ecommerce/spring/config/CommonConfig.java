package coding.example.ecommerce.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"coding.example.ecommerce"})
@EntityScan(basePackages = {"coding.example.ecommerce.entity"})
@EnableJpaRepositories(basePackages = {"coding.example.ecommerce.repository"})
@EnableWebMvc
public class CommonConfig {
}
