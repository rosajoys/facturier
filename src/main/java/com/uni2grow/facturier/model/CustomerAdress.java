package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_adresses")
public class CustomerAdress {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Customer")
    private  Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_Adress")
    private Adress adress;
}
