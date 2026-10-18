package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/addUser")
    String addUser(@RequestBody UserRequest userRequest){
        String userName = userRequest.getName();
        String userEmail = userRequest.getEmail();
        System.out.println("User name: " + userName);
        System.out.println("User email: " + userEmail);
        return "User name: " + userName + " with email: " + userEmail + " was created!";
    }
}
