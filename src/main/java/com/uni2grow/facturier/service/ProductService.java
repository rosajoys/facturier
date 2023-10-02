package com.uni2grow.facturier.service;


import com.uni2grow.facturier.model.Product;
import com.uni2grow.facturier.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProductById(final Long idProduct){
        return productRepository.findById(idProduct);
    }
    public Iterable<Product>getProducts(){

        return productRepository.findAll();
    }

    public void deleteProduct(final Long idProduct){
        productRepository.deleteById(idProduct);
    }

    public Product saveProduct(Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
