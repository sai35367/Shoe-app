package com.shoeshop.shoeapp.orderandcart;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderAndCartRepository extends MongoRepository<OrderAndCart, String> {
    List<OrderAndCart> findAllByUserIdAndStatus(String userId, int status);

    void deleteByUserIdAndProductId(String userId, String productId);
}
