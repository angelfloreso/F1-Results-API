package com.apex.demo.controller;

import com.apex.demo.services.CircuitService;
import com.apex.demo.model.Circuits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(path="/Circuits") // This means URL's start with /demo (after Application path)
public class CircuitsController {
    @Autowired
    private CircuitService circuitService;

    @GetMapping(value = "/{id}")
    public @ResponseBody Circuits getCircuit(@PathVariable int id) {
        return circuitService.getById(id);
    }

    @GetMapping(value = "/byName/{name}")
    public @ResponseBody List<Circuits> getCircuitByName(@PathVariable String name) {
        return circuitService.findByName(name);
    }

    @GetMapping(value = "/all")
    public @ResponseBody List<Circuits> getAll() {
        return circuitService.getAllCircuits();
    }
    @GetMapping(value = "/byCountry/{nameCountry}")
    public @ResponseBody List<Circuits> getCircuitByCountry(@PathVariable String nameCountry) {
        return circuitService.findByCountry(nameCountry);
    }

}
