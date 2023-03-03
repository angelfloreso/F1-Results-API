package com.apex.demo.services;

import com.apex.demo.model.Results;
import com.apex.demo.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResultsServices {
    @Autowired
    ResultsRepository resultsRepository;

    @Transactional
    public List<Results> getAllResults() {
        return (List<Results>) resultsRepository.findAll();
    }
    @Transactional
    public List<Results> findByPosition(int position) {
        return resultsRepository.findByPosition(position);
    }
    @Transactional
    public List<Results> findByDate(String date) {
        return resultsRepository.findByDate(date);
    }
    @Transactional
    public List<Results> findByRace(String name) {
        return resultsRepository.findByRace(name);
    }
    @Transactional
    public List<Results> findByCircuit(String name) {
        return resultsRepository.findByCircuit(name);
    }
    @Transactional
    public List<Results> findByCountry(String nameCountry) {
        return resultsRepository.findByCountry(nameCountry);
    }

    @Transactional
    public List<Results> findByConstructor(String name) {
        return resultsRepository.findByConstructor(name);
    }

    @Transactional
    public List<Results> findByPoints(int points) {
        return resultsRepository.findByPoints(points);
    }

    @Transactional
    public List<Results> findByForename(String name) {
        return resultsRepository.findByForename(name);
    }

    @Transactional
    public List<Results> findBySurname(String name) {
        return resultsRepository.findBySurname(name);
    }



    @Transactional
    public Results getById(int id) {
        return resultsRepository.findById(id);
    }
}
