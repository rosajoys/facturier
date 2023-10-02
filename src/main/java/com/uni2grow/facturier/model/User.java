package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;

    String firstNameUser;

    String lastNameUser;

    String adressUser;

    Integer telUtilisateur;

}
