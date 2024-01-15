package com.restAPIremastered.persistance.dto;

import org.springframework.stereotype.Component;

@Component
public class RoundDTO {

    private int id;
    private String date;
    private int number;

    // Constructors, getters, setters


    public RoundDTO() {
    }

    public RoundDTO(int id, String date, int number) {
        this.id = id;
        this.date = date;
        this.number = number;
    }

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