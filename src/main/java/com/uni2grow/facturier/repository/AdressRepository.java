package com.uni2grow.facturier.repository;

import com.uni2grow.facturier.model.Adress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends CrudRepository<Adress, Long> {
}
