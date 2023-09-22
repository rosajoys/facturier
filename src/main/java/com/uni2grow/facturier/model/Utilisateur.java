package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUtilisateur;

    String nomUtilisateur;

    String prenomUtilisateur;

    String adresseUtilisateur;

    Integer telUtilisateur;

}
