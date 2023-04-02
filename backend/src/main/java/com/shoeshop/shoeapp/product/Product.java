package com.shoeshop.shoeapp.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private String productImageURL;
    private double productPrice;
}
