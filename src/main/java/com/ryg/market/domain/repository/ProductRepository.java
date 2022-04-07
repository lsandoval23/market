package com.ryg.market.domain.repository;

import com.ryg.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    // En esta clase se va a indicar el nombre de los metodos que cualquier repositorio que trabaje con metodos
    // tenga que implementar

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);


}
