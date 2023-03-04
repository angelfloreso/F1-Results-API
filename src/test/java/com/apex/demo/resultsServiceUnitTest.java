package com.apex.demo;

import com.apex.demo.repository.ResultsRepository;
import com.apex.demo.services.ResultsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;
//@SpringBootTest
//@Sql("/ImportScript.sql")
@ExtendWith(MockitoExtension.class)
public class resultsServiceUnitTest {

    @Mock
    private ResultsRepository resultsRepository;

    //@InjectMocks // auto inject helloRepository

    /*@BeforeEach
    void init() {
    }*/

    @DisplayName("Test getAllResultss")
    @Test
    void getAllResultss() {
        /*Results Results = new Resultss(2,"sepang","Sepang International Results","Kuala Lumpur","Malaysia",2.76083f,101.738f,18,"http://en.wikipedia.org/wiki/Sepang_International_Results");

        when(resultsService.(2)).thenReturn(C2);*/
        /*ResultsServices resultsService = mock(ResultsServices.class);
        when(resultsService.getAllResults()).thenReturn(Collections.emptyList());

        assertEquals("USA", resultsRepository.findById(1).getCountry());*/
    }


}
