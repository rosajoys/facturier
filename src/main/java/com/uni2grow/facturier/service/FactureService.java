package com.uni2grow.facturier.service;

import com.uni2grow.facturier.model.Facture;
import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    private FactureRepository factureRepository;

    public Optional<Facture> getFactureById(final Long num_facture) {
        return factureRepository.findById(num_facture);
    }

    public Iterable<Facture> getFacture() {

        return factureRepository.findAll();
    }

    public void deleFacture(final Long num_facture) {
        factureRepository.deleteById(num_facture);
    }

    public Facture saveProduit(Facture facture) {
        Facture savedFacture = factureRepository.save(facture);
        return savedFacture;
    }
}
