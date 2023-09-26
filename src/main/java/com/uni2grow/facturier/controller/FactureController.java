package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.*;
import com.uni2grow.facturier.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FactureController {
    @Autowired
    private FactureService factureService;
// creation ou ajout d'une nouvelle facture
    @PostMapping("/factures")
    public Facture createFacture(@RequestBody Facture facture) {
        return factureService.saveFacture(facture);
    }
//recuperation de la facture ou affichage de celle-ci
    @GetMapping("/factures")
    public Iterable<Facture> getFacture() {
        return factureService.getFacture();
    }
//mise a jour de la facture
    @PutMapping("/factures/{id_facture}")
    public Facture updateFacture(@PathVariable("id_facture") final Long idFacture, @RequestBody Facture facture) {
        Optional<Facture> fa = factureService.getFactureById(idFacture);

        if (fa.isPresent()) {
            Facture currentFacture = fa.get();
            Long id = facture.getIdFacture();
            if (id != 0) {
                currentFacture.setIdFacture(id);
            }

            String number = facture.getNumFacture();
            if (number!=null){
                currentFacture.setNumFacture(number);
            }

            Client cl = facture.getClient();
            Long idc = cl.getIdClient();
            if (idc != 0) {
                cl.setIdClient(idc);
                currentFacture.setClient(cl);
            }

            Utilisateur ut = facture.getUtilisateur();
            Long idu = ut.getIdUtilisateur();
            if (idu != 0) {
                ut.setIdUtilisateur(idu);
                currentFacture.setUtilisateur(ut);
            }
            return currentFacture;
        }else {
            return null;
        }
    }
//suppression de la facture en utilisant son identifiant
    @DeleteMapping("/factures/{id_facture}")
    public void deleteFacture(@PathVariable("id_facture") final Long idFacture){
        factureService.deleteFacture(idFacture);
    }
}