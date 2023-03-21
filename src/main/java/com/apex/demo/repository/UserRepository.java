package com.apex.demo.repository;

import java.util.Optional;

import com.apex.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByToken(String token);

    Boolean existsByUsername(String username);

    Boolean existsByToken(String token);

    @Query(value = "SELECT u.token FROM User u where u.username = ?1 and u.password = ?2")
    String login(String username, String password);
}