package com.apex.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
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

    public Results(long id, Date date, String race, String circuit, String country, String constructor, int points, String forename, String surname) {
        this.id = id;
        this.date = date;
        this.race = race;
        this.circuit = circuit;
        this.country = country;
        this.constructor = constructor;
        this.points = points;
        this.forename = forename;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPosition(int position) {
        this.position = Integer.valueOf(position);
    }

    public int getPosition() {
        return position;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
