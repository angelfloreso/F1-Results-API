package com.apex.demo.controller;

import com.apex.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @GetMapping("/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        String token= userService.login(username, password);
        if(token.equals("")){
            return "no token found";
        }
        return token;
    }
}
