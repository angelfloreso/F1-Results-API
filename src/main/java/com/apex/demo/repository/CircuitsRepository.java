package com.apex.demo.repository;


import com.apex.demo.model.Circuits;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CircuitsRepository<Circuits> extends CrudRepository<Circuits, Integer> {

    List<Circuits> findByName(String name);

    List<Circuits> findAll();

    Circuits findById(int id);

    @Override
    default <S extends Circuits> S save(S entity) {
        return null;
    }

    void saveAll(List<Circuits> names);

    @Query("select c from Circuits c where c.country = :countryName")
    List<Circuits> findByCountry(@Param("countryName") String countryName);

}