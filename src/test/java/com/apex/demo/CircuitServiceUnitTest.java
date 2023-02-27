package com.apex.demo;

import com.apex.demo.model.Circuits;
import com.apex.demo.repository.CircuitsRepository;
import com.apex.demo.services.CircuitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CircuitServiceUnitTest {
    @Mock
    private CircuitsRepository circuitsRepository;

    @InjectMocks // auto inject helloRepository
    private CircuitService circuitService = new CircuitService();

    Circuits C1;
    Circuits C2;
    List<Circuits> CIRCUITS = new ArrayList<>();

    @BeforeEach
    void init() {
        C1 = new Circuits(1,"albert_park","Albert Park Grand Prix Circuit","Melbourne","Australia",-37.8497f,144.968f,10,"http://en.wikipedia.org/wiki/Melbourne_Grand_Prix_Circuit");
        C2 = new Circuits(2,"sepang","Sepang International Circuit","Kuala Lumpur","Malaysia",2.76083f,101.738f,18,"http://en.wikipedia.org/wiki/Sepang_International_Circuit");
        CIRCUITS.add(C1);
        CIRCUITS.add(C2);
    }

    @DisplayName("Test getAllCircuits")
    @Test
    void getAllCircuits() {
        Circuits circuit = new Circuits(2,"sepang","Sepang International Circuit","Kuala Lumpur","Malaysia",2.76083f,101.738f,18,"http://en.wikipedia.org/wiki/Sepang_International_Circuit");

        when(circuitsRepository.findById(2)).thenReturn(C2);
        assertEquals(circuit.getName(), circuitService.getById(2).getName());
    }
    @DisplayName("Test getAllCircuitss")
    @Test
    void getAllCircuitss() {
        Circuits circuit = new Circuits(1,"albert_park","Albert Park Grand Prix Circuit","Melbourne","Australia",-37.8497f,144.968f,10,"http://en.wikipedia.org/wiki/Melbourne_Grand_Prix_Circuit");

        when(circuitsRepository.saveAll(CIRCUITS));

        assertEquals(circuit.getName(), circuitService.findByName("Albert Park Grand Prix Circuit"));
    }


}
