package com.apex.demo.controller;

import com.apex.demo.model.Results;
import com.apex.demo.services.ResultsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/Results") // This means URL's start with /demo (after Application path)
public class ResultsController {

    @Autowired
    private ResultsServices resultService;

    @GetMapping(value = "/{id}")
    public @ResponseBody Results getById(@PathVariable int id) {
        return resultService.getById(id);
    }

    @GetMapping(value = "/byPosition/{position}")
    public @ResponseBody List<Results> getPosition(@PathVariable int position) {
        return resultService.findByPosition(position);
    }

    @GetMapping(value = "/byDate/{date}")
    public @ResponseBody List<Results> getPosition(@PathVariable String date) {
        return resultService.findByDate(date);
    }

    @GetMapping(value = "/byRaceName/{name}")
    public @ResponseBody List<Results> getRaceByName(@PathVariable String name) {
        return resultService.findByRace(name);
    }

    @GetMapping(value = "/byCircuitName/{name}")
    public @ResponseBody List<Results> getCircuitByName(@PathVariable String name) {
        return resultService.findByCircuit(name);
    }

    @GetMapping(value = "/byCountry/{nameCountry}")
    public @ResponseBody List<Results> getCircuitByCountry(@PathVariable String nameCountry) {
        return resultService.findByCountry(nameCountry);
    }

    @GetMapping(value = "/byConstructorName/{name}")
    public @ResponseBody List<Results> getConstructorByName(@PathVariable String name) {
        return resultService.findByConstructor(name);
    }

    @GetMapping(value = "/byPoints/{points}")
    public @ResponseBody List<Results> getByPosition(@PathVariable int points) {
        return resultService.findByPoints(points);
    }

    @GetMapping(value = "/byForename/{name}")
    public @ResponseBody List<Results> getByForeName(@PathVariable String name) {
        return resultService.findByForename(name);
    }

    @GetMapping(value = "/bySurname/{name}")
    public @ResponseBody List<Results> getBySurName(@PathVariable String name) {
        return resultService.findBySurname(name);
    }


    @GetMapping(value = "/all")
    public @ResponseBody List<Results> getAll() {
        return resultService.getAllResults();
    }
}
