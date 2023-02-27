package com.apex.demo.services;

import java.util.List;

import com.apex.demo.model.Circuits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apex.demo.repository.CircuitsRepository;

@Service
public class CircuitService {
    @Autowired
    CircuitsRepository circuitsRepository;

    @Transactional
    public List<Circuits> getAllCircuits() {
        return (List<Circuits>) circuitsRepository.findAll();
    }

    @Transactional
    public List<Circuits> findByName(String name) {
        return circuitsRepository.findByName(name);
    }

    @Transactional
    public Circuits getById(int id) {
        return circuitsRepository.findById(id);
    }
    @Transactional
    public List<Circuits> findByCountry(String nameCountry) {
        return circuitsRepository.findByCountry(nameCountry);
    }
}
