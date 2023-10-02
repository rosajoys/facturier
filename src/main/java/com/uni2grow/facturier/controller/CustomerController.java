package com.uni2grow.facturier.controller;


import com.uni2grow.facturier.model.Customer;
import com.uni2grow.facturier.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/clients")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @GetMapping("customers/{id_customer}")
    public Customer getCustomer(@PathVariable("id_customer") final Long idCustomer){
        Optional<Customer> customer = customerService.getCustomerById(idCustomer);
        if(customer.isPresent()){
            return customer.get();
        }else
            return null;
    }
    @GetMapping("/customers")
    public Iterable<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @PutMapping("/customers/{id_customer}")
    public Customer updateCustomer(@PathVariable("id_customer") final Long idCustomer, @RequestBody Customer customer){
        Optional<Customer> cl=customerService.getCustomerById(idCustomer);
        if(cl.isPresent()) {
            Customer currentCustomer = cl.get();
            String firstName = customer.getFirstNameCustomer();
            if (firstName != null) {
                currentCustomer.setFirstNameCustomer(firstName);
            }

            String lastName = customer.getLastNameCustomer();
            if (lastName != null) {
                currentCustomer.setLastNameCustomer(lastName);
            }

            int numTel = customer.getTelCustomer();
            if (numTel != 0) {
                currentCustomer.setTelCustomer(numTel);
            }
            customerService.saveCustomer(currentCustomer);
            return currentCustomer;
        }else {
            return null;
        }
    }
    @DeleteMapping("/customers/{id_customer}")
    public void deleteClient(@PathVariable("id-customer") final Long idCustomer){
        customerService.deleteCustomerById(idCustomer);
    }
}
