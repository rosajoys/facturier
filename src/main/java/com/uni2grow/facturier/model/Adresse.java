package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "adresse")
public class Adresse {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdresse;

   @Column(name = "natureAdresse")
   private String natureAdresse;
   private String bpAdresse;
   private String ville;
   private String rue;

}
