package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;

    String nomClient;

    String prenomClient;

    Integer telClient;

    @ManyToMany
    private List<Client> adresse = new ArrayList<>();

    @ManyToMany
    private List<Client> produit = new ArrayList<>();

   }

