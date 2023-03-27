package com.apex.demo.services;

import com.apex.demo.model.User;
import com.apex.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    private static String TOKEN = "2176d2c3-89c8-4c3e-acab-253f9b32FFFF";
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    public void loginTest() {
        // Given
        when(userRepository.login(any(), any())).thenReturn(TOKEN);
        // When
        String res = userService.login("username", "password");
        // then
        assertEquals(TOKEN, res);
    }
    @Test
    public void loginNewTest() {
        // When
        String res = userService.login("username", "password");
        // then
        assertNotEquals(TOKEN, res);
    }
    @Test
    public void findByUsernameTest() {
        String testUsername = "testUsername";
        // Given
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(new User(testUsername,"password",TOKEN)));
        // When
        String res = userService.findByUsername(testUsername);
        // then
        assertEquals(TOKEN, res);
    }
    @Test
    public void findByUsernameNotFoundTest() {
        String testUsername = "testUsername";
        // When
        String res = userService.findByUsername(testUsername);
        // then
        assertEquals("", res);
    }
    @Test
    public void findByTokenTest() {
        String testUsername = "testUsername";
        // Given
        when(userRepository.findByToken(any())).thenReturn(Optional.of(new User(testUsername,"password",TOKEN)));
        // When
        Optional<org.springframework.security.core.userdetails.User> res = userService.findByToken(TOKEN);
        // then
        assertEquals(testUsername, res.get().getUsername());
    }
    @Test
    public void findByTokenNotFoundTest() {
        // When
        Optional<org.springframework.security.core.userdetails.User> res = userService.findByToken(TOKEN);
        // then
        assertEquals(Optional.empty(), res);
    }
    @Test
    public void existsByUsernameTest() {
        // Given
        when(userRepository.existsByUsername(any())).thenReturn(true);
        // When
        boolean res = userService.existsByUsername("username");
        // then
        assertEquals(true, res);
    }
    @Test
    public void existsByTokenTest() {
        // Given
        when(userRepository.existsByToken(any())).thenReturn(true);
        // When
        boolean res = userService.existsByToken(TOKEN);
        // then
        assertEquals(true, res);
    }
}
