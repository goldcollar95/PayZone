package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

public class ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);
}
