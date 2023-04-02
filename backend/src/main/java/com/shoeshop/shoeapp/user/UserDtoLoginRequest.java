package com.shoeshop.shoeapp.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDtoLoginRequest {
    private String userEmail;
    private String userPassword;
}
