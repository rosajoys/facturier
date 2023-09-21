package com.uni2grow.facturier.service;

import com.uni2grow.facturier.model.Adresse;
import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.repository.AdresseRepository;
import com.uni2grow.facturier.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdresseService {
    @Autowired
    private AdresseRepository adresseRepository;

    public Optional<Adresse> getAdresseById(final Long id_adresse){
        return adresseRepository.findById(id_adresse);
    }
    public Iterable<Adresse>getAdresse(){

        return adresseRepository.findAll();
    }
//    public Iterable<Adresse> getAdresseByName(String ville){
//        return adresseRepository.findByName(ville);
//    }

    public void deleAdresse(final Long id_adresse){
        adresseRepository.deleteById(id_adresse);
    }

    public Adresse saveAdresse(Adresse adresse){
        Adresse savedAdresse = adresseRepository.save(adresse);
        return savedAdresse;
    }
}
