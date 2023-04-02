package com.shoeshop.shoeapp.user;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void newUser(@RequestBody UserDtoRequest dtoRequest) {
        User user = new User();
        BeanUtils.copyProperties(dtoRequest, user);
        userService.addUser(user);
    }

    @PostMapping("/login")
    public UserDtoResponse login(@RequestBody UserDtoLoginRequest dtoLoginRequest) {
        final String userEmail = dtoLoginRequest.getUserEmail();
        final String userPassword = dtoLoginRequest.getUserPassword();

        User user = userService.login(userEmail, userPassword);
        if (user != null) {
            var dtoResponse = new UserDtoResponse();
            BeanUtils.copyProperties(user, dtoResponse);

            return dtoResponse;
        }

        return null;
    }
}
