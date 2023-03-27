package com.apex.demo.services;

import com.apex.demo.model.Results;
import com.apex.demo.repository.ResultsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class ResultsServices {
    @Autowired
    ResultsRepository resultsRepository;

    @Transactional
    public List<Results> getAllResults(Pageable page) {
        log.info("Get All Results");
        return (List<Results>) resultsRepository.findAll(page);
    }
    @Transactional
    public List<Results> findByPosition(int position, Pageable page) {
        log.info("Get By Position {}", position);
        return resultsRepository.findByPosition(position, page);
    }
    @Transactional
    public List<Results> findByDate(String date, Pageable page) {
        log.info("Get By Date {}", date);
        return resultsRepository.findByDate(date, page);
    }
    @Transactional
    public List<Results> findByRace(String name, Pageable page) {
        log.info("Get By Race {}", name);
        return resultsRepository.findByRace(name, page);
    }
    @Transactional
    public List<Results> findByCircuit(String name, Pageable page) {
        log.info("Get By Circuit {}", name);
        return resultsRepository.findByCircuit(name, page);
    }
    @Transactional
    public List<Results> findByCountry(String nameCountry, Pageable page) {
        log.info("Get By Country {}", nameCountry);
        return resultsRepository.findByCountry(nameCountry, page);
    }

    @Transactional
    public List<Results> findByConstructor(String name, Pageable page) {
        log.info("Get By Constructor {}", name);
        return resultsRepository.findByConstructor(name, page);
    }

    @Transactional
    public List<Results> findByPoints(int points, Pageable page) {
        log.info("Get By Points {}", points);
        return resultsRepository.findByPoints(points, page);
    }

    @Transactional
    public List<Results> findByForename(String name, Pageable page) {
        log.info("Get By Forename {}", name);
        return resultsRepository.findByForename(name, page);
    }

    @Transactional
    public List<Results> findBySurname(String name, Pageable page) {
        log.info("Get By Surname {}", name);
        return resultsRepository.findBySurname(name, page);
    }

    @Transactional
    public Results getById(int id) {
        log.info("Get By Id {}", id);
        return resultsRepository.findById(id);
    }
}
