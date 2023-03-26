package com.apex.demo.services;

import com.apex.demo.data.DummyResults;
import com.apex.demo.model.Results;
import com.apex.demo.repository.ResultsRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(SpringExtension.class)
public class ResultsServiceTest {

    @Mock
    private ResultsRepository resultsRepository;
    @InjectMocks
    private ResultsServices resultService;

    private Pageable paging = PageRequest.of(0, 20);

    @Test
    public void findAllTest() {
        // Given
        when(resultsRepository.findAll(any())).thenReturn(DummyResults.RESULTLIST);
        // When
        List<Results> arrr = resultService.getAllResults(paging);
        // then
        assertEquals(20, arrr.size());
    }
    @Test
    public void findByPositionTest() {
        log.info("checking findByPositionTest");
        int position = 0;
        // Given
        when(resultsRepository.findByPosition(position, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByPosition(position, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(position, arrr.get(0).getPosition());
    }
    @Test
    public void findByDateTest() {
        log.info("checking findByDateTest");
        String date = new Date(1668902400).toString();
        // Given
        when(resultsRepository.findByDate(date, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByDate(date, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(date.toString(), arrr.get(0).getDate().toString());
    }
    @Test
    public void findByRaceTest() {
        String race = "Abu Dhabi Grand Prix";
        // Given
        when(resultsRepository.findByRace(race, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByRace(race, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(race.toString(), arrr.get(0).getRace());
    }
    @Test
    public void findByCircuitTest() {
        String circuit = "Yas Marina Circuit";
        // Given
        when(resultsRepository.findByCircuit(circuit, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByCircuit(circuit, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(circuit, arrr.get(0).getCircuit());
    }
    @Test
    public void findByCountryTest() {
        String country = "UAE";
        // Given
        when(resultsRepository.findByCountry(country, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByCountry(country, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(country, arrr.get(0).getCountry());
    }
    @Test
    public void findByConstructorTest() {
        String constructor = "Alpine F1 Team";
        // Given
        when(resultsRepository.findByConstructor(constructor, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByConstructor(constructor, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(constructor, arrr.get(0).getConstructor());
    }
    @Test
    public void findByPointsTest() {
        int points = 0;
        // Given
        when(resultsRepository.findByPoints(points, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByPoints(points, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(points, arrr.get(0).getPoints());
    }
    @Test
    public void findByForenameTest() {
        String forename = "Fernando";
        // Given
        when(resultsRepository.findByForename(forename, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByForename(forename, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(forename, arrr.get(0).getForename());
    }
    @Test
    public void findBySurnameTest() {
        String surename = "Alonso";
        // Given
        when(resultsRepository.findBySurname(surename, paging)).thenReturn(DummyResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findBySurname(surename, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(surename, arrr.get(0).getSurname());
    }
    @Test
    public void findByIdTest() {
        int id = 25840;
        // Given
        when(resultsRepository.findById(id)).thenReturn(DummyResults.ONE_RESULTLIST.get(0));
        // When
        Results res = resultService.getById(id);
        // then
        assertEquals(id, res.getId());
    }
}
