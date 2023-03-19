package com.apex.demo.repository;

import com.apex.demo.model.Results;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository  extends CrudRepository<Results, Long> {

    Results findById(int id);
    List<Results> findByPosition(int position, Pageable pageable);
    List<Results> findByDate(String date, Pageable pageable);
    List<Results> findByRace(String name, Pageable pageable);
    List<Results> findByCircuit(String name, Pageable pageable);
    List<Results> findByCountry(String name, Pageable pageable);
    List<Results> findByConstructor(String name, Pageable pageable);
    List<Results> findByPoints(int points, Pageable pageable);
    List<Results> findByForename(String name, Pageable pageable);
    List<Results> findBySurname(String name, Pageable pageable);
    List<Results> findAll(Pageable pageable);


    /*@Query("select c from Results c where c.country = :countryName")
    List<Results> findByCountry(@Param("countryName") String countryName);*/
}
