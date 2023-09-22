package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Adresse;
import com.uni2grow.facturier.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @PostMapping("/adresse/{id_adresse}")
    public Adresse createAdresse(@RequestBody Adresse adresse){
        return adresseService.saveAdresse(adresse);
    }

    @GetMapping("/adresse")
    public Iterable<Adresse> getAdresse(){
      return adresseService.getAdresse();
    }

    @PutMapping("/adresse/{id_adresse}")
    public Adresse updateAdresse(@PathVariable("id_adresse") final long id_adresse, @RequestBody Adresse adresse){
        Optional<Adresse> ad = adresseService.getAdresseById(id_adresse);
        if (ad.isPresent()){
            Adresse currentAdresse = ad.get();
            String nature = adresse.getNature_adresse();
            if (nature!= null){
                currentAdresse.setNature_adresse(nature);
            }
            String ville = adresse.getVille();
            if (ville!=null){
                currentAdresse.setVille(ville);
            }

            String box = adresse.getBp_adresse();
            if (box!=null){
                currentAdresse.setBp_adresse(box);
            }

            String rue = adresse.getRue();
            if (rue!=null){
                currentAdresse.setRue(rue);
            }
            return currentAdresse;
        }else {
            return null;
        }
    }
}
