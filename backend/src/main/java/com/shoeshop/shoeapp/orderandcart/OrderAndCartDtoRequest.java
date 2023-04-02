package com.shoeshop.shoeapp.orderandcart;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderAndCartDtoRequest {
    private String productId;
    private String userId;
}
