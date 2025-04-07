package io.github.ordermanagement.repository;


import io.github.ordermanagement.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductRepository {
    private Map<Long, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void removeProductById(Long id) {
        products.remove(id);
    }
}
