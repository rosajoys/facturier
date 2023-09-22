package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.model.Client;
import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("client/{idClient}")
    public Client getClient(@PathVariable("idClient") final Long idClient){
        Optional<Client> client = clientService.getClientById(idClient);
        if(client.isPresent()){
            return client.get();
        }else
            return null;
    }
    @GetMapping("/client")
    public Iterable<Client> getClient(){
        return clientService.getClient();
    }


    @PutMapping("/client/{idClient}")
    public Client updateClient(@PathVariable("idClient") final Long idClient, @RequestBody Client client){
        Optional<Client> cl=clientService.getClientById(idClient);
        if(cl.isPresent()) {
            Client currentClient = cl.get();
            String firstName = client.getNomClient();
            if (firstName != null) {
                currentClient.setNomClient(firstName);
            }

            String lastName = client.getPrenomClient();
            if (lastName != null) {
                currentClient.setPrenomClient(lastName);
            }

            int numTel = client.getTelClient();
            if (numTel != 0) {
                currentClient.setTelClient(numTel);
            }
            clientService.saveClient(currentClient);
            return currentClient;
        }else {
            return null;
        }
    }

    @DeleteMapping("/client/{idClient}")
    public void deleteClient(@PathVariable("IdClient") final Long idClient){
        clientService.deleClientById(idClient);
    }
}
