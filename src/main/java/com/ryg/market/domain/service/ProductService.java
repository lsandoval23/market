package com.ryg.market.domain.service;

import com.ryg.market.domain.Product;
import com.ryg.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    /** Atributos */
    // Autowired internamente llama a producto repository que es la clase que trabaja con la base de datos
    @Autowired
    private ProductRepository productRepository;

    /** Metodos de la capa de servicio */


    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId) {

        /* Otra alternativa de implementacion
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
        */

        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }

    }





}
