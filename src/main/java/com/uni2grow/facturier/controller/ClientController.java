package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public Iterable<Client> getClient(){
        return clientService.getClient();
    }

    @PutMapping("/client/{id_client}")
    public Client updateClient(@PathVariable("id_client") final Long id_client, @RequestBody Client client){
        Optional<Client> cl=clientService.getClientById(id_client);
        if(cl.isPresent()) {
            Client currentClient = cl.get();
            String firstName = client.getNom_client();
            if (firstName != null) {
                currentClient.setNom_client(firstName);
            }

            String lastName = client.getPrenom_client();
            if (lastName != null) {
                currentClient.setPrenom_client(lastName);
            }

            int numTel = client.getTel_client();
            if (numTel != 0) {
                currentClient.setTel_client(numTel);
            }
            clientService.saveClient(currentClient);
            return currentClient;
        }else {
            return null;
        }
    }

    @DeleteMapping("/client/{id_client}")
    public void deleteClient(@PathVariable("Id_client") final Long id_client){
        clientService.deleClientById(id_client);
    }
}
