package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.model.Utilisateur;
import com.uni2grow.facturier.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/utilisateurs")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.saveUtilisateur(utilisateur);
    }
    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateur(){
      return utilisateurService.getUtilisateur();
    }
}
