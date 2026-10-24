package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/welcome")

public class WelcomeController {

    @GetMapping("/user")
    public String welcomeUser(@RequestParam String name){
        return "Welcome. " + name + "!";
    }
}
