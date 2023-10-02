package com.uni2grow.facturier.repository;

import com.uni2grow.facturier.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

//    public Iterable<Produit> findByName(String nom_produit);
}