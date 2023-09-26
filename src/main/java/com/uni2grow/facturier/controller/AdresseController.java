package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Adresse;
import com.uni2grow.facturier.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @PostMapping("/adresses")
    public Adresse createAdresse(@RequestBody Adresse adresse){
        return adresseService.saveAdresse(adresse);
    }

    @GetMapping("/adresses")
    public Iterable<Adresse> getAdresse(){
      return adresseService.getAdresse();
    }

    @PutMapping("/adresses/{id_adresse}")
    public Adresse updateAdresse(@PathVariable("id_adresse") final long idAdresse, @RequestBody Adresse adresse){
        Optional<Adresse> ad = adresseService.getAdresseById(idAdresse);
        if (ad.isPresent()){
            Adresse currentAdresse = ad.get();
            String nature = adresse.getNatureAdresse();
            if (nature!= null){
                currentAdresse.setNatureAdresse(nature);
            }
            String ville = adresse.getVille();
            if (ville!=null){
                currentAdresse.setVille(ville);
            }

            String box = adresse.getBpAdresse();
            if (box!=null){
                currentAdresse.setBpAdresse(box);
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
    @DeleteMapping("/adresse/{id_adresse}")
    public void deleteAdresse(@PathVariable("id_adresse") final Long idAdresse){
        adresseService.deleteAdresse(idAdresse);
    }
}
