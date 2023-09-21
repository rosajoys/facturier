package com.uni2grow.facturier.repository;

import com.uni2grow.facturier.model.Adresse;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Long> {

//    public Iterable<Adresse> findByName(String ville);
}
