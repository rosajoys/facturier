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

    public Optional<Adresse> getAdresseById(final Long idAdresse){
        return adresseRepository.findById(idAdresse);
    }
    public Iterable<Adresse>getAdresse(){

        return adresseRepository.findAll();
    }

    public void deleteAdresse(final Long idAdresse){
        adresseRepository.deleteById(idAdresse);
    }

    public Adresse saveAdresse(Adresse adresse){
        Adresse savedAdresse = adresseRepository.save(adresse);
        return savedAdresse;
    }
}
