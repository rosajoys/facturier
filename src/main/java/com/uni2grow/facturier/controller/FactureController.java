package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.model.Facture;
import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.model.Utilisateur;
import com.uni2grow.facturier.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FactureController {
    @Autowired
    private FactureService factureService;
// creation ou ajout d'une nouvelle facture
    @PostMapping("/facture")
    public Facture createFacture(@RequestBody Facture facture) {
        return factureService.saveFacture(facture);
    }
//recuperation de la facture ou affichage de celle-ci
    @GetMapping("/facture")
    public Iterable<Facture> getFacture() {
        return factureService.getFacture();
    }
//mise a jour de la facture
    @PutMapping("/facture/{num_facture}")
    public Facture updateFacture(@PathVariable("num_facture") final Long num_facture, @RequestBody Facture facture) {
        Optional<Facture> fa = factureService.getFactureById(num_facture);

        if (fa.isPresent()) {
            Facture currentFacture = fa.get();
            Long id = facture.getNum_facture();
            if (id != 0) {
                currentFacture.setNum_facture(id);
            }

            Client cl = facture.getClient();
            Long idc = cl.getId_client();
            if (idc != 0) {
                cl.setId_client(idc);
                currentFacture.setClient(cl);
            }

            Utilisateur ut = facture.getUtilisateur();
            Long idu = ut.getNum_utilisateur();
            if (idu != 0) {
                ut.setNum_utilisateur(idu);
                currentFacture.setUtilisateur(ut);
            }
            return currentFacture;
        }else {
            return null;
        }
    }
//suppression de la facture en utilisant son identifiant
    @DeleteMapping("/facture/{num_facture}")
    public void deleteFacture(@PathVariable("num_facture") final Long num_facture){
        factureService.deleFacture(num_facture);
    }
}