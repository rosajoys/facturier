package com.uni2grow.facturier.repository;

import com.uni2grow.facturier.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

//    public Iterable<Produit> findByName(String nom_produit);
}