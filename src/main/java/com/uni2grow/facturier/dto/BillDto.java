package com.uni2grow.facturier.dto;

import com.uni2grow.facturier.model.Bill;
import com.uni2grow.facturier.model.Customer;
import com.uni2grow.facturier.model.Product;
import com.uni2grow.facturier.model.User;
import lombok.Data;

import java.util.List;

@Data
public class BillDto {

    private Long idBill;
    private String numBill;

    private Customer customer;

    private User user;

    private List<Product> products;

    public boolean isPresent() {
        return true;
    }

    Bill bill = new Bill();
    public Bill get() {
    return bill;
    }
}
