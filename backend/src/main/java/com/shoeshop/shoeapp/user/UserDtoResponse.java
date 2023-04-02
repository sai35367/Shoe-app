package com.shoeshop.shoeapp.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDtoResponse {
    private String userId;
    private int userRole;
}