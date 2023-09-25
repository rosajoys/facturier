package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "composer")
public class Composer {
    @Id
    @OneToOne
    @JoinColumn(name = "idFacture")
    private Facture facture;

    @OneToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;
}
