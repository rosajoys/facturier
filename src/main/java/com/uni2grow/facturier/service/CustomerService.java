package com.uni2grow.facturier.service;



import com.uni2grow.facturier.model.Customer;
import com.uni2grow.facturier.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(final Long idCustomer){
        return customerRepository.findById(idCustomer);
    }
    public Iterable<Customer>getCustomers(){

        return customerRepository.findAll();
    }



    public void deleteCustomerById(final Long idCustomer){
        customerRepository.deleteById(idCustomer);
    }

    public Customer saveCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }
}
