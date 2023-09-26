package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_adresses")
public class CustomerAdress {
    @Id
    @OneToOne
    @JoinColumn(name = "idClient")
    private  Client client;

    @OneToOne
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;
}
