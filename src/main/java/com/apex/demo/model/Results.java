package com.apex.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Getter
@Setter
@Table(name = "resultsview")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "position")
    private int position;
    @Column(name = "date")
    private Date date;
    @Column(name = "race")
    private String race;
    @Column(name = "circuit")
    private String circuit;
    @Column(name = "country")
    private String country;
    @Column(name = "constructor")
    private String constructor;
    @Column(name = "points")
    private int points;
    @Column(name = "forename")
    private String forename;
    @Column(name = "surname")
    private String surname;

    public Results() {
    }

    public Results(long id, int position, Date date, String race, String circuit, String country, String constructor, int points, String forename, String surname) {
        this.id = id;
        this.position = position;
        this.date = date;
        this.race = race;
        this.circuit = circuit;
        this.country = country;
        this.constructor = constructor;
        this.points = points;
        this.forename = forename;
        this.surname = surname;
    }
}
