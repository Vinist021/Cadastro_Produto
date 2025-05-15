package com.abutua.product_backend.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.product_backend.models.Product;
@CrossOrigin
@RestController
public class ProductController {

    private List<Product> products = Arrays.asList( 
        new Product(1, "Computador M1-TX", "Intel I7, 16GB, SSD 256, HT 1TB",
        4900.00, 2, true, true),
        new Product(2, "Computador M2-TX", "Intel I7, 32GB, SSD 512, HT 1TB",
        5900.00, 3, false, true),
        new Product(3, "Computador M1-T", "Intel I5, 8GB, HT 1TB",
        2900.00, 1, false, false)                   
    );

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
       
        Product prod = products.stream()
                                .filter(p -> p.getId() == id)
                                .findFirst()
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        return ResponseEntity.ok(prod);
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return products;
    }

}
