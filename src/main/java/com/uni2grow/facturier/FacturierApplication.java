package com.uni2grow.facturier;



import com.uni2grow.facturier.service.BillService;
import com.uni2grow.facturier.service.CustomerService;
import com.uni2grow.facturier.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FacturierApplication  implements CommandLineRunner{

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private BillService billService;

	public static void main(String[] args) {
		SpringApplication.run(FacturierApplication.class, args);}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

	}
}
