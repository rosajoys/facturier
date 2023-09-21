package com.uni2grow.facturier.repository;

import com.uni2grow.facturier.model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
}
