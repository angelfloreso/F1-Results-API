package com.apex.demo.data;

import com.apex.demo.model.Results;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class DummyResults {

    public static final List<Results> RESULTLIST = new ArrayList<Results>(){
        {
            add(new Results(25840, 0, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Alpine F1 Team", 0, "Fernando", "Alonso"));
            add(new Results(15006, 1, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Red Bull", 25, "Max", "Verstappen"));
            add(new Results(15007, 2, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Ferrari", 18, "Charles", "Leclerc"));
            add(new Results(15008, 3, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Red Bull", 15, "Sergio", "Pérez"));
            add(new Results(15009, 4, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Ferrari", 12, "Carlos", "Sainz"));
            add(new Results(15010, 5, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Mercedes", 10, "George", "Russell"));
            add(new Results(15011, 6, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "McLaren", 9, "Lando", "Norris"));
            add(new Results(15012, 7, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Alpine F1 Team", 6, "Esteban", "Ocon"));
            add(new Results(15013, 8, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Aston Martin", 4, "Lance", "Stroll"));
            add(new Results(15014, 9, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "McLaren", 2, "Daniel", "Ricciardo"));
            add(new Results(15015, 10, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Aston Martin", 1, "Sebastian", "Vettel"));
            add(new Results(15016, 11, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "AlphaTauri", 0, "Yuki", "Tsunoda"));
            add(new Results(15017, 12, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Alfa Romeo", 0, "Guanyu", "Zhou"));
            add(new Results(15018, 13, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Williams", 0, "Alexander", "Albon"));
            add(new Results(15019, 14, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "AlphaTauri", 0, "Pierre", "Gasly"));
            add(new Results(15020, 15, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Alfa Romeo", 0, "Valtteri", "Bottas"));
            add(new Results(15021, 16, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Haas F1 Team", 0, "Mick", "Schumacher"));
            add(new Results(15022, 17, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Haas F1 Team", 0, "Kevin", "Magnussen"));
            add(new Results(15023, 18, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Mercedes", 0, "Lewis", "Hamilton"));
            add(new Results(15024, 19, new Date(1668902400), "Abu Dhabi Grand Prix", "Yas Marina Circuit", "UAE", "Williams", 0, "Nicholas", "Latifi"));
        }
    };

    public static final List<Results> ONE_RESULTLIST = new ArrayList<Results>(){

        {
            add(DummyResults.RESULTLIST.get(0));
        }
    };
}
