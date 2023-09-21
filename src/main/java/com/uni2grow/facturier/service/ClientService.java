package com.uni2grow.facturier.service;



import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClientById(final Long id_client){
        return clientRepository.findById(id_client);
    }
    public Iterable<Client>getClient(){

        return clientRepository.findAll();
    }

//    public Iterable<Client> getClientByName(String nom_client){
//        return clientRepository.findByName(nom_client);
//    }

    public void deleClientById(final Long id_client){
        clientRepository.deleteById(id_client);
    }

    public Client saveClient(Client client){
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
}
