package com.apex.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
