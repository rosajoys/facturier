package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
@Access(AccessType.FIELD)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long num_utilisateur;

    @Column(name = "first_name")
    String nom_utilisateur;

    @Column(name = "last_name")
    String prenom_utilisateur;

    String adresse_utilisateur;

    Integer tel_utilisateur;

}
