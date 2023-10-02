package com.uni2grow.facturier.controller;

import com.uni2grow.facturier.dto.BillDto;
import com.uni2grow.facturier.model.Adress;
import com.uni2grow.facturier.model.Bill;
import com.uni2grow.facturier.model.Customer;
import com.uni2grow.facturier.model.User;
import com.uni2grow.facturier.service.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BillController {
    @Autowired
    private BillService billService;
// creation ou ajout d'une nouvelle facture
    @PostMapping("/bills")
    public Bill createBill(@RequestBody Bill bill) {
        return billService.saveBill(bill);
    }

    @GetMapping("bills/{id_bill}")
    public BillDto getBill(@PathVariable("id_bill") final Long idBill) {
        BillDto billDto = billService.getBillById(idBill);
        return billDto;
    }
//recuperation de la facture ou affichage de celle-ci
    @GetMapping("/bills")
    public BillDto getBills() {
       BillDto billDto = billService.getBills();
       return billDto;
    }
//mise a jour de la facture

    @PutMapping("/bills/{id_bill}")
    public Bill updateBill(@PathVariable("id_bill") final Long idBill, @RequestBody Bill bill) {
        BillDto fa = billService.getBillById(idBill);
        if (fa.isPresent()) {
            Bill currentBill = fa.get();
            Long id =  bill.getIdBill();
            if (id != 0) {
                currentBill.setIdBill(id);
            }

            String number = bill.getNumBill();
            if (number!=null){
                currentBill.setNumBill(number);
            }

            Customer cl = bill.getCustomer();
            Long idc = cl.getIdCustomer();
            if (idc != 0) {
                cl.setIdCustomer(idc);
                currentBill.setCustomer(cl);
            }

            User ut = bill.getUser();
            Long idu = ut.getIdUser();
            if (idu != 0) {
                ut.setIdUser(idu);
                currentBill.setUser(ut);
            }
            return currentBill;
        }else {
            return null;
        }
    }
//suppression de la facture en utilisant son identifiant
    @DeleteMapping("/bills/{id_bill}")
    public void deleteBill(@PathVariable("id_bill") final Long idBill){
        billService.deleteBill(idBill);
    }
}