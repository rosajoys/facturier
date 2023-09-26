package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "factures")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFacture;

    String numFacture;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

}

