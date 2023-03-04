package com.apex.demo.services;

import com.apex.demo.model.Results;
import com.apex.demo.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResultsServices {
    @Autowired
    ResultsRepository resultsRepository;

    @Transactional
    public List<Results> getAllResults(Pageable page) {
        return (List<Results>) resultsRepository.findAll(page);
    }
    @Transactional
    public List<Results> findByPosition(int position, Pageable page) {
        return resultsRepository.findByPosition(position, page);
    }
    @Transactional
    public List<Results> findByDate(String date, Pageable page) {
        return resultsRepository.findByDate(date, page);
    }
    @Transactional
    public List<Results> findByRace(String name, Pageable page) {
        return resultsRepository.findByRace(name, page);
    }
    @Transactional
    public List<Results> findByCircuit(String name, Pageable page) {
        return resultsRepository.findByCircuit(name, page);
    }
    @Transactional
    public List<Results> findByCountry(String nameCountry, Pageable page) {
        return resultsRepository.findByCountry(nameCountry, page);
    }

    @Transactional
    public List<Results> findByConstructor(String name, Pageable page) {
        return resultsRepository.findByConstructor(name, page);
    }

    @Transactional
    public List<Results> findByPoints(int points, Pageable page) {
        return resultsRepository.findByPoints(points, page);
    }

    @Transactional
    public List<Results> findByForename(String name, Pageable page) {
        return resultsRepository.findByForename(name, page);
    }

    @Transactional
    public List<Results> findBySurname(String name, Pageable page) {
        return resultsRepository.findBySurname(name, page);
    }

    @Transactional
    public Results getById(int id) {
        return resultsRepository.findById(id);
    }
}
