package com.apex.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String username;
    private String password;
    private String token;

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.token = email;
    }
}
