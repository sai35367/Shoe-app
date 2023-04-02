package com.shoeshop.shoeapp.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDtoRequest {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
}
