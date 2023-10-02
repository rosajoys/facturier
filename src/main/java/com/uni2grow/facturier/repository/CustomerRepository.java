package com.uni2grow.facturier.repository;


import com.uni2grow.facturier.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

//    public Iterable<Client> findByName(String nom_client);
}
