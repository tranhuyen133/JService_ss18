package re.ss18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ss18.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}