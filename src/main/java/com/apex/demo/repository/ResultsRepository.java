package com.apex.demo.repository;

import com.apex.demo.model.Results;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository  extends CrudRepository<Results, Long> {

    com.apex.demo.model.Results findById(int id);
    List<Results> findByPosition(int position);
    List<Results> findByDate(String date);
    List<Results> findByRace(String name);
    List<Results> findByCircuit(String name);
    List<Results> findByCountry(String name);
    List<Results> findByConstructor(String name);
    List<Results> findByPoints(int points);
    List<Results> findByForename(String name);
    List<Results> findBySurname(String name);
    List<Results> findAll();
    @Override
    default <S extends Results> S save(S entity) {
        return null;
    }

    /*@Query("select c from Results c where c.country = :countryName")
    List<Results> findByCountry(@Param("countryName") String countryName);*/
}
