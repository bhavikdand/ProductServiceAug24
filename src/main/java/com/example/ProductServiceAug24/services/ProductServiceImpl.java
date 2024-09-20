package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.projections.ProductInfo;
import com.example.ProductServiceAug24.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("dbImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        ProductInfo productInfo = productRepository.getProductInfo(id);
        System.out.println(productInfo.getDescp());
        System.out.println(productInfo.getName());
        System.out.println(productInfo.getId());


        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        else {
            throw new ProductNotFoundException("Product with id:" + id + " is not available");
        }
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        /*
        select * from products where name = {name}
        if the above query returns a product, then do not create a new product
         */
        Product p = productRepository.findFirstByNameAndCategory(name, category);
        if(p != null){
            return p;
        }
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(description);
        product.setName(name);
        product = productRepository.save(product);
        System.out.println(product.getId());
        return product;
    }

    public boolean deleteById(long id){
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        pageSize = Math.min(pageSize, 100);
        return productRepository.findAll(PageRequest.of(pageNum, pageSize,
                Sort.by("name").descending().and(
                        Sort.by("category")
                )));
    }
}
