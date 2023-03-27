package com.apex.demo.controllers;

import com.apex.demo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenControllerTest {

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mvc;

    @Test
    public void getTokenTest() throws Exception {
        String username = "dev";
        String password = "pa$$word";
        // Given
        when(userService.login(username, password)).thenReturn("2176d2c3-89c8-4c3e-acab-253f9b32FFFF");
        // When
        mvc.perform(get("/token")
                        .param("username", username)
                        .param("password", password)
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2176d2c3")));
    }
    @Test
    public void getTokenNotFoundTest() throws Exception {
        // Given
        when(userService.login(any(), any())).thenReturn("");
        // When
        mvc.perform(get("/token")
                        .param("username", "")
                        .param("password", "")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("no token found")));
    }
}
