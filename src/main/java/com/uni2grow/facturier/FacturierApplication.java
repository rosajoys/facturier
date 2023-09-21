package com.uni2grow.facturier;



import com.uni2grow.facturier.model.Produit;
import com.uni2grow.facturier.service.ClientService;
import com.uni2grow.facturier.service.FactureService;
import com.uni2grow.facturier.service.ProduitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FacturierApplication  implements CommandLineRunner{

	@Autowired
	private ClientService clientService;

	@Autowired
	private ProduitService produitService;

	@Autowired
	private FactureService factureService;

	public static void main(String[] args) {
		SpringApplication.run(FacturierApplication.class, args);}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

	}
}
