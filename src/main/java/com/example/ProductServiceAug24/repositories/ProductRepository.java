package com.example.ProductServiceAug24.repositories;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.projections.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // select * from products where name = {name} and category = {category}
    Product findFirstByNameAndCategory(String name, String category);

    // Find all products
    // select * from products
    List<Product> findAll();

    // Find product by Id
    // select * from products where id = {id}
//    Product findById(long id);

    // Find all products by category
    // select * from products where category = {category}
    List<Product> findAllByCategory(String category);

    Optional<Product> findById(long id);

    List<Product> findAllByNameLike(String word);

    List<Product> findAllByNameLikeIgnoreCase(String word);

    List<Product> findAllByIdLessThan(long id);

    @Query("select p.name, p.category from Product p where p.id = :id")
    List<Product> selectById(long id);

    @Query(value = "select * from product p where p.id =:id", nativeQuery = true)
    Product selectById2(long id);

    @Query(nativeQuery = true,
    value = "select p.id, p.name, p.description as descp from product p where id=:id")
    ProductInfo getProductInfo(long id);
}
