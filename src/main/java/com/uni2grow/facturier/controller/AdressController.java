package com.uni2grow.facturier.controller;


import com.uni2grow.facturier.model.Adress;
import com.uni2grow.facturier.service.AdressService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@RestController
public class AdressController {
    @Autowired
    private AdressService adressService;

    @PostMapping("/adresses")
    public Adress createAdress(@RequestBody Adress adress){
        return adressService.saveAdress(adress);
    }

    @GetMapping("/adresses")
    public Iterable<Adress> getAdresses(){
      return adressService.getAdresses();
    }

    @PutMapping("/adresses/{id_adress}")
    public Adress updateAdresse(@PathVariable("id_adress") final long idAdress, @RequestBody Adress adress){
        Optional<Adress> ad = adressService.getAdressById(idAdress);
        if (ad.isPresent()){
            Adress currentAdress = ad.get();
            String nature = adress.getNatureAdress();
            if (nature!= null){
                currentAdress.setNatureAdress(nature);
            }
            String ville = adress.getVille();
            if (ville!=null){
                currentAdress.setVille(ville);
            }

            String box = adress.getBpAdress();
            if (box!=null){
                currentAdress.setBpAdress(box);
            }

            String rue = adress.getRue();
            if (rue!=null){
                currentAdress.setRue(rue);
            }
            return currentAdress;
        }else {
            return null;
        }
    }
    @DeleteMapping("/adresses/{id_adress}")
    public void deleteAdresse(@PathVariable("id_adress") final Long idAdress){
        adressService.deleteAdress(idAdress);
    }
}
