package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "adresses")
public class Adress {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdress;

   private String natureAdress;
   private String bpAdress;
   private String ville;
   private String rue;

}
