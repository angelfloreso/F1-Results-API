package com.apex.demo.controllers;


import com.apex.demo.controller.ResultsController;
import com.apex.demo.data.DummyResults;
import com.apex.demo.repository.ResultsRepository;
import com.apex.demo.services.ResultsServices;
import com.apex.demo.services.UserService;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

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
@Sql(scripts = {"file:src/test/resources/token.sql"})
public class ResultControllerTest {

    @MockBean
    private ResultsServices resultService;
    @Autowired
    private MockMvc mvc;
    private Pageable paging = PageRequest.of(0, 10);

    @Test
    public void getByIdTest() throws Exception {
        int id = 25840;
        // Given
        when(resultService.getById(id)).thenReturn(DummyResults.ONE_RESULTLIST.get(0));
        // When
        mvc.perform(get("/api/v1/{id}", id)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(""+id)));
    }
    @Test
    public void findByPositionTest() throws Exception {
        int position = 0;
        // Given
        when(resultService.findByPosition(position, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byPosition/{position}", position)
                                .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                                .param("page", "0")
                                .param("size", "10")
                                .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(""+position)));
    }
    @Test
    public void findByDateTest() throws Exception {
        String date = new Date(1668902400).toString();
        // Given
        when(resultService.findByDate(date, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byDate/{date}", date)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("date")));
    }
    @Test
    public void findByRaceTest() throws Exception {
        String race = "Abu Dhabi Grand Prix";
        // Given
        when(resultService.findByRace(race, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byRaceName/{name}", race)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(race)));
    }
    @Test
    public void findByCircuitTest() throws Exception {
        String circuit = "Yas Marina Circuit";
        // Given
        when(resultService.findByCircuit(circuit, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byCircuitName/{name}", circuit)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(circuit)));
    }
    @Test
    public void byCountryTest() throws Exception {
        String country = "UAE";
        // Given
        when(resultService.findByCountry(country, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byCountry/{nameCountry}", country)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
            // then
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(country)));
    }
    @Test
    public void findByConstructorTest() throws Exception {
        String constructor = "Alpine F1 Team";
        // Given
        when(resultService.findByConstructor(constructor, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byConstructorName/{name}", constructor)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(constructor)));
    }
    @Test
    public void findByPointsTest() throws Exception {
        int points = 0;
        // Given
        when(resultService.findByPoints(points, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byPoints/{points}", points)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(""+points)));
    }
    @Test
    public void findByForenameTest() throws Exception {
        String forename = "Fernando";
        // Given
        when(resultService.findByForename(forename, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/byForename/{name}", forename)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(forename)));
    }
    @Test
    public void findbySurnameTest() throws Exception {
        String surname = "Alonso";
        // Given
        when(resultService.findBySurname(surname, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        mvc.perform(get("/api/v1/bySurname/{name}", surname)
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(surname)));
    }
    @Test
    public void getAllResultsTest() throws Exception {
        // Given
        when(resultService.getAllResults(any())).thenReturn(DummyResults.RESULTLIST);
        // When
        mvc.perform(get("/api/v1/all")
                        .header("Authorization", "2176d2c3-89c8-4c3e-acab-253f9b32FFFF")
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"surname\":\"Latifi\"")));
    }
}
