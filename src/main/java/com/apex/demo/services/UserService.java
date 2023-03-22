package com.apex.demo.services;

import com.apex.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import com.apex.demo.model.User;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String login(String username, String password) {
        String token = userRepository.login(username, password);
        if(token == null){
            token = UUID.randomUUID().toString();
            User custom = new User(username, password, token);
            userRepository.save(custom);
        }

        log.info("New username {} with token {}", username, token);
        return token;
    }

    public String findByUsername(String username) {
        Optional<User> customer = userRepository.findByUsername(username);
        if(customer.isPresent()){
            return customer.get().getToken();
        }
        return "";
    }

    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
        Optional<User> customer= userRepository.findByToken(token);
        if(customer.isPresent()){
            User customer1 = customer.get();
            org.springframework.security.core.userdetails.User user= new org.springframework.security.core.userdetails.User(customer1.getUsername(), customer1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    public boolean existsByToken(String token) {
        return userRepository.existsByToken(token);
    }
}
