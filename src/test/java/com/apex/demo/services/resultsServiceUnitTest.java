package com.apex.demo.services;

import com.apex.demo.model.Results;
import com.apex.demo.repository.ResultsRepository;
import com.apex.demo.services.ResultsServices;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//@Sql("/ImportScript.sql")
@Slf4j
@RunWith(SpringRunner.class)
public class resultsServiceUnitTest {
    private List<Results> RESULTLIST;

    {
        RESULTLIST = new ArrayList<>();
        RESULTLIST.add(new Results(1, new Date(),
                "Abu Dhabi Grand Prix","Yas Marina Circuit",
                "UAE","McLaren",9,"Lando","Norris"));
        RESULTLIST.add(new Results(2, new Date(),
                "Abu Dhabi Grand Prix","Yas Marina Circuit",
                "UAE","McLaren",9,"Lando","Norris"));
    }

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
        when(resultsRepository.findAll(any())).thenReturn(RESULTLIST);
        // When
        List<Results> arrr = resultService.getAllResults(paging);
        // then
        assertEquals(2, arrr.size());
    }

    @Test
    public void findByCountryTest() {
        // Given
        when(resultsRepository.findByCountry("UAE", paging)).thenReturn(RESULTLIST);
        // When
        List<Results> arrr = resultService.findByCountry("UAE", paging);
        // then
        assertEquals(2, arrr.size());
        assertEquals("UAE", arrr.get(0).getCountry());
    }
    /*@DisplayName("Test")
    @Test
    public void testFindTheGreatestFromAllData() {
    // Given
    when(trailerForecastService.deleteCarrierMethodDetails(any(), any(), any())).thenReturn(new CarrierMethodDeleteResponse());
    // When
    mvc.perform(MockMvcRequestBuilders.delete("/api/trailer-forecast/carrier-method-details")
            .header("BY_PASS_TOKEN", "true")
                    .param("fcNumber", "6545")
                    .param("carrierMethodCode", "5444")
                    .param("lastModifiedBy", "2323-01-01")
                    .contentType(MediaType.APPLICATION_JSON))
            // then
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(containsString("statusMessage")));



    }*/
}
