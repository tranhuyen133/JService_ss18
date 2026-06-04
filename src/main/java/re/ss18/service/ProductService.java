package re.ss18.service;


import re.ss18.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product create(Product product);

    Product update(Long id, Product product);

    void delete(Long id);
}