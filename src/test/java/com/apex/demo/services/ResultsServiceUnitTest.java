package com.apex.demo.services;

import com.apex.demo.data.TestResults;
import com.apex.demo.model.Results;
import com.apex.demo.repository.ResultsRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//@Sql("/ImportScript.sql")
@Slf4j
@RunWith(SpringRunner.class)
public class ResultsServiceUnitTest {

    @Mock
    private ResultsRepository resultsRepository;
    @InjectMocks
    private ResultsServices resultService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    private Pageable paging = PageRequest.of(0, 20);

    @Test
    public void findAllTest() {
        // Given
        when(resultsRepository.findAll(any())).thenReturn(TestResults.RESULTLIST);
        // When
        List<Results> arrr = resultService.getAllResults(paging);
        // then
        assertEquals(20, arrr.size());
    }
    @Test
    public void findByPositionTest() {
        // Given
        when(resultsRepository.findByPosition(1, paging)).thenReturn(TestResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByPosition(1, paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals(0, arrr.get(0).getPosition());
    }
    @Test
    public void findByCountryTest() {
        // Given
        when(resultsRepository.findByCountry("UAE", paging)).thenReturn(TestResults.ONE_RESULTLIST);
        // When
        List<Results> arrr = resultService.findByCountry("UAE", paging);
        // then
        assertEquals(1, arrr.size());
        assertEquals("UAE", arrr.get(0).getCountry());
    }

}
