package com.uni2grow.facturier.service;


import com.uni2grow.facturier.model.Utilisateur;
import com.uni2grow.facturier.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    public Iterable<Utilisateur>getUtilisateur(){
        return utilisateurRepository.findAll();
    }
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return savedUtilisateur;
    }
}
