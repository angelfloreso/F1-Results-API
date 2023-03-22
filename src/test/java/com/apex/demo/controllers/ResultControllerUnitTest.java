package com.apex.demo.controllers;


import com.apex.demo.controller.ResultsController;
import com.apex.demo.data.TestResults;
import com.apex.demo.repository.ResultsRepository;
import com.apex.demo.services.ResultsServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ResultControllerUnitTest {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private ResultsServices resultService;
    @Autowired
    private MockMvc mvc;

    @Autowired
    ResultsRepository resultsRepository;
    private Pageable paging = PageRequest.of(0, 10);

    ResultsController resultsController;

    @Test
    public void byCountryTest() throws Exception {
    // Given
    when(resultService.findByCountry("UAE", paging)).thenReturn(TestResults.ONE_RESULTLIST);
    // When
    mvc.perform(get("/api/v1/byCountry/{nameCountry}", "UAE")
                    .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b3282b7")
                    .param("page", "0")
                    .param("size", "10")
                    .contentType(MediaType.APPLICATION_JSON))
            // then
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("UAE")));

    }

    @Test
    public void bySurnameTest() throws Exception {
        // Given
        when(resultService.findBySurname("Alonso", paging)).thenReturn(TestResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/bySurname/{name}", "Alonso")
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b3282b7")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Alonso")));

    }

    @Test
    public void getAllTest() throws Exception {
        // Given
        when(resultService.getAllResults(any())).thenReturn(TestResults.RESULTLIST);
        // When
        mvc.perform(get("/api/v1/all")
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b3282b7")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"surname\":\"Latifi\"")));

    }
}
