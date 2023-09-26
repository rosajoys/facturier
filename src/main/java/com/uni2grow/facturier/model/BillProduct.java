package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bill_products")
public class BillProduct {
    @Id
    @OneToOne
    @JoinColumn(name = "idFacture")
    private Facture facture;

    @OneToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;
}
