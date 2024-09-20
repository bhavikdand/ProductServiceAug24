package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.dtos.CreateProductRequestDto;
import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("fakeStore")
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

    @GetMapping()
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum
    ){
        Page<Product> products= productService.getAllProducts(pageSize, pageNum);
        return ResponseEntity.ok(products);
    }

}
