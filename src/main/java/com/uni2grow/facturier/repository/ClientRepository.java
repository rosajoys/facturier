package com.uni2grow.facturier.repository;


import com.uni2grow.facturier.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

//    public Iterable<Client> findByName(String nom_client);
}
