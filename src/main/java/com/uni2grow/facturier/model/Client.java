package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_client;

    @Column(name = "first_name")
    String nom_client;

    @Column(name = "last_name")
    String prenom_client;

    Integer tel_client;

   }

