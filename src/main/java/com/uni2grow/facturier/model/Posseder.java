package com.uni2grow.facturier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posseder")
public class Posseder {
    @Id
    @OneToOne
    @JoinColumn(name = "idClient")
    private  Client client;

    @OneToOne
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;
}
