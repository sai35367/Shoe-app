package com.shoeshop.shoeapp.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
@Document
@Setter
@Getter
public class User {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private int userRole; // 1 - admin 0 - user

}