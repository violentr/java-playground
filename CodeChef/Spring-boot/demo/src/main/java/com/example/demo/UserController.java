package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    public List<User> users = new ArrayList<>();

    @PostMapping("/addUser")
    String addUser(@RequestBody UserRequest userRequest){
        String userName = userRequest.getName();
        String userEmail = userRequest.getEmail();
        User user = new User(userName, userEmail);
        users.add(user);
        return "User name: " + userName + " with email: " + userEmail + " was created!";
    }
    @GetMapping("/users")
    List<User> listUsers(){
        return users;
    }
}
