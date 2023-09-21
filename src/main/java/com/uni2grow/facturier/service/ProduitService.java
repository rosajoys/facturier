package com.uni2grow.facturier.service;

import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.repository.ClientRepository;
import com.uni2grow.facturier.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Optional<Produit> getProduitById(final Long num_produit){
        return produitRepository.findById(num_produit);
    }
    public Iterable<Produit>getProduit(){

        return produitRepository.findAll();
    }

//    public Iterable<Produit> getProduitByName(String nom_produit){
//        return produitRepository.findByName(nom_produit);
//    }
    public void deleProduit(final Long num_produit){
        produitRepository.deleteById(num_produit);
    }

    public Produit saveProduit(Produit produit){
        Produit savedProduit = produitRepository.save(produit);
        return savedProduit;
    }
}
