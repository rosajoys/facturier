package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduit;

    String nomProduit;
    double PrixProduit;
    double qtteProduit;
    double poids;
}
