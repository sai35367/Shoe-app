package com.shoeshop.shoeapp.orderandcart;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class OrderAndCart {
    @Id
    private String Id;
    private String productId;
    private String userId;
    private int status; // 0 - cart, 1 - Order
}