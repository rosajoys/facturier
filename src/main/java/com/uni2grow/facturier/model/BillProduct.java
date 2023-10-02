package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bill_products")
public class BillProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
