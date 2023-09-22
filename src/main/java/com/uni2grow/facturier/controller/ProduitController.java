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

    @GetMapping("/produit/{idProduit}")
    public Produit getProduit(@PathVariable("idProduit") final Long idProduit){
        Optional<Produit> produit = produitService.getProduitById(idProduit);
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
    @PutMapping("/produit/{idProduit}")
    public Produit updateProduit(@PathVariable("idProduit") final Long idProduit, @RequestBody Produit produit){
        Optional<Produit> pr=produitService.getProduitById(idProduit);
        if(pr.isPresent()) {
            Produit currentProduit = pr.get();
            String firstName = produit.getNomProduit();
            if (firstName != null) {
                currentProduit.setNomProduit(firstName);
            }

            double prix = produit.getPrixProduit();
            if (prix != 0.0) {
                currentProduit.setPrixProduit(prix);
            }

            double quantite = produit.getQtteProduit();
            if (quantite!=0.0) {
                currentProduit.setQtteProduit(quantite);
            }
            produitService.saveProduit(currentProduit);
            return currentProduit;
        }else {
            return null;
        }
    }

    @DeleteMapping("/produit/{idProduit}")
    public void deleteProduit(@PathVariable("idProduit") final Long idProduit){
        produitService.deleProduit(idProduit);
    }
}
