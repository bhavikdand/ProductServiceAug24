package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    // GET /products/{id}
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
        if( productId < 1 || productId > 20){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));

    }
}
