package com.shoeshop.shoeapp.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * ProductRepository
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{$in: ?0}")
    public List<Product> getProductsIn(List<String> productId);

}