package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStore")
public class FakeStoreProductService implements ProductService{


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException{
        /*
        Take the id from the input, and call this endpoint:a
        https://fakestoreapi.com/products/ + id
         */
        /*
        To install docker use this:
        docker run --name my-redis -d -p 6379:6379 redis
         */
        Product product = (Product) this.redisTemplate.opsForHash().get("PRODUCTS", "product_" + id);
        if(product != null){
            return product;
        }
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDto fakeStoreProductDto = this.restTemplate.getForObject(url, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id:" + id + " was not found");
        }
        product = convertFakeStoreProductToProduct(fakeStoreProductDto);
        this.redisTemplate.opsForHash().put("PRODUCTS", "product_" + id, product);
        return product;

    }

    @Override
    public Product createProduct(String name, String category, String description) {


        return null;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto dto){
        Product product = new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        return null;
    }
}
