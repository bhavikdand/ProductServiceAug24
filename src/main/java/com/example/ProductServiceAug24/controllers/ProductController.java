package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.dtos.CreateProductRequestDto;
import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("dbImpl")
    private ProductService productService;
    // GET /products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
//        if( productId < 1 || productId > 20){
//            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//        }
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));

    }

    @PostMapping()
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        System.out.println(requestDto);
        // Add basic validation
//        if(requestDto.getName() == null){
//            throw new Exception();
//        }

        return productService.createProduct(requestDto.getName(), requestDto.getCategory(),
                requestDto.getDescription());
    }
}
