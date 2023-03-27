package com.apex.demo.controller;

import com.apex.demo.model.Results;
import com.apex.demo.services.ResultsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class ResultsController {

    @Autowired
    private ResultsServices resultService;

    @GetMapping(value = "/{id}")
    public @ResponseBody Results getById(@PathVariable int id) {
        return resultService.getById(id);
    }

    @GetMapping(value = "/byPosition/{position}")
    public @ResponseBody List<Results> getPosition(@PathVariable int position,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "20") int size
    ) {
        return resultService.findByPosition(position, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byDate/{date}")
    public @ResponseBody List<Results> getPosition(@PathVariable String date,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "20") int size) {
        return resultService.findByDate(date, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byRaceName/{name}")
    public @ResponseBody List<Results> getRaceByName(@PathVariable String name,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "20") int size) {
        return resultService.findByRace(name, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byCircuitName/{name}")
    public @ResponseBody List<Results> getCircuitByName(@PathVariable String name,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "20") int size) {
        return resultService.findByCircuit(name, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byCountry/{nameCountry}")
    public @ResponseBody List<Results> getCircuitByCountry(@PathVariable String nameCountry,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "20") int size) {
        return resultService.findByCountry(nameCountry, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byConstructorName/{name}")
    public @ResponseBody List<Results> getConstructorByName(@PathVariable String name,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "20") int size) {
        return resultService.findByConstructor(name, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byPoints/{points}")
    public @ResponseBody List<Results> getByPosition(@PathVariable int points,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "20") int size) {
        return resultService.findByPoints(points, PageRequest.of(page, size));
    }

    @GetMapping(value = "/byForename/{name}")
    public @ResponseBody List<Results> getByForeName(@PathVariable String name,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "20") int size) {
        return resultService.findByForename(name, PageRequest.of(page, size));
    }

    @GetMapping(value = "/bySurname/{name}")
    public @ResponseBody List<Results> getBySurName(@PathVariable String name,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "20") int size) {
        return resultService.findBySurname(name, PageRequest.of(page, size));
    }


    @GetMapping(value = "/all")
    public @ResponseBody List<Results> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "20") int size) {
        return resultService.getAllResults(PageRequest.of(page, size));
    }
}
