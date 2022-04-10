package com.ryg.market.domain.repository;

import com.ryg.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    // La implementacion de los metodos se encuentra en ProductoRepository, mediante el mapper
    // Se mapea a producto.

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);


}
