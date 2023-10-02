package com.uni2grow.facturier.controller;


import com.uni2grow.facturier.model.Product;
import com.uni2grow.facturier.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

// la methode suivante permet de creer ou ajouter un nouveau produit
@PostMapping("/products")
public Product createProduct(@RequestBody Product product){
    return productService.saveProduct(product);
}

    @GetMapping("/products/{id_product}")
    public Product getProduit(@PathVariable("id_product") final Long idProduct){
        Optional<Product> product = productService.getProductById(idProduct);
        if(product.isPresent()){
            return product.get();
        }else
            return null;
    }

//   la methode suivante permet de recuperer tous les produits de la bd
    @GetMapping("/products")
    public Iterable<Product> getProducts(){
        return productService.getProducts();
    }

//    la methode suivante permet de mettre a jour un produit existant
    @PutMapping("/products/{id_product}")
    public Product updateProduit(@PathVariable("id_product") final Long idProduct, @RequestBody Product product){
        Optional<Product> pr=productService.getProductById(idProduct);
        if(pr.isPresent()) {
            Product currentProduct = pr.get();
            String firstName = product.getNameProduct();
            if (firstName != null) {
                currentProduct.setNameProduct(firstName);
            }

            double price = product.getPriceProduct();
            if (price != 0.0) {
                currentProduct.setPriceProduct(price);
            }

            double quantity = product.getQttyProduct();
            if (quantity!=0.0) {
                currentProduct.setQttyProduct(quantity);
            }
            productService.saveProduct(currentProduct);
            return currentProduct;
        }else {
            return null;
        }
    }

    @DeleteMapping("/products/{id_product}")
    public void deleteProduct(@PathVariable("id_product") final Long idProduct){
        productService.deleteProduct(idProduct);
    }
}
