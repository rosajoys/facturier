package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.service.ClientService;
import com.uni2grow.facturier.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProduitController {
    @Autowired
    private ProduitService produitService;

// la methode suivante permet de creer ou ajouter un nouveau produit
    @PostMapping("/produit")
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    @GetMapping("/produit/{num_produit}")
    public Produit getProduit(@PathVariable("num_produit") final Long num_produit){
        Optional<Produit> produit = produitService.getProduitById(num_produit);
        if(produit.isPresent()){
            return produit.get();
        }else
            return null;
    }

//   la methode suivante permet de recuperer tous les produits de la bd
    @GetMapping("/produit")
    public Iterable<Produit> getProduit(){
        return produitService.getProduit();
    }

//    la methode suivante permet de mettre a jour un produit existant
    @PutMapping("/produit/{num_produit}")
    public Produit updateProduit(@PathVariable("num_produit") final Long num_produit, @RequestBody Produit produit){
        Optional<Produit> pr=produitService.getProduitById(num_produit);
        if(pr.isPresent()) {
            Produit currentProduit = pr.get();
            String firstName = produit.getNom_produit();
            if (firstName != null) {
                currentProduit.setNom_produit(firstName);
            }

            double prix = produit.getPrix_produit();
            if (prix != 0.0) {
                currentProduit.setPrix_produit(prix);
            }

            double quantite = produit.getQtte_produit();
            if (quantite!=0.0) {
                currentProduit.setQtte_produit(quantite);
            }
            produitService.saveProduit(currentProduit);
            return currentProduit;
        }else {
            return null;
        }
    }

    @DeleteMapping("/produit/{num_produit}")
    public void deleteProduit(@PathVariable("num_produit") final Long num_produit){
        produitService.deleProduit(num_produit);
    }
}
