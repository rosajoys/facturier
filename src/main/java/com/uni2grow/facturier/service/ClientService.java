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

    public Optional<Client> getClientById(final Long idClient){
        return clientRepository.findById(idClient);
    }
    public Iterable<Client>getClient(){

        return clientRepository.findAll();
    }



    public void deleteClientById(final Long idClient){
        clientRepository.deleteById(idClient);
    }

    public Client saveClient(Client client){
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
}
