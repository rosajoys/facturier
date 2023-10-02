package com.uni2grow.facturier.model;

import com.uni2grow.facturier.dto.BillDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;


@Data
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBill;

    String numBill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private User user;

}

