package re.ss18.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss18.entity.Product;
import re.ss18.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl
        implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {

        Product p =
                productRepository.findById(id)
                        .orElseThrow();

        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setSize(product.getSize());
        p.setToppings(product.getToppings());

        return productRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
