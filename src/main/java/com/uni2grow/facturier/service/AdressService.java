package com.uni2grow.facturier.service;



import com.uni2grow.facturier.model.Adress;
import com.uni2grow.facturier.repository.AdressRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AdressService {
    @Autowired
    private AdressRepository adressRepository;

    public Optional<Adress> getAdressById(final Long idAdresse){
        return adressRepository.findById(idAdresse);
    }
    public Iterable<Adress>getAdresses(){

        return adressRepository.findAll();
    }

    public void deleteAdress(final Long idAdresse){
        adressRepository.deleteById(idAdresse);
    }

    public Adress saveAdress(Adress adress){
        Adress savedAdresse = adressRepository.save(adress);
        return savedAdresse;
    }
}
