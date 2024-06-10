package com.restAPIremastered.persistance.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "round")
public class Round {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "Date must be in the format day.month.year")
    @Column(name = "date")
    private String date;

    @Column(name = "number")
    private int number;

    //constructors
    public Round( int id, String date, int number) {

        this.id = id;
        this.date = date;
        this.number = number;
    }

    public Round(){}


    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
