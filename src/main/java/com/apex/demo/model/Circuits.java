package com.apex.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "circuits")
public class Circuits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "circuitRef")
    private String circuitRef;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "country")
    private String country;
    @Column(name = "lat")
    private float lat;
    @Column(name = "lng")
    private float lng;
    @Column(name = "alt")
    private float alt;
    @Column(name = "url")
    private String url;

    public Circuits() {
    }

    public Circuits(long id, String circuitRef, String name, String location, String country, float lat, float lng, float alt, String url) {
        this.id = id;
        this.circuitRef = circuitRef;
        this.name = name;
        this.location = location;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.url = url;
    }

    public Long getCircuitId() {
        return id;
    }

    public void setCircuitId(Long circuitId) {
        this.id = circuitId;
    }

    public String getCircuitRef() {
        return circuitRef;
    }

    public void setCircuitRef(String circuitRef) {
        this.circuitRef = circuitRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getAlt() {
        return alt;
    }

    public void setAlt(float alt) {
        this.alt = alt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}