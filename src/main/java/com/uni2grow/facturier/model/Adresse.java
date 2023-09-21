package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "adresse")
public class Adresse {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adresse;

   private String nature_adresse;
   private String bp_adresse;
   private String ville;
   private String rue;

}
