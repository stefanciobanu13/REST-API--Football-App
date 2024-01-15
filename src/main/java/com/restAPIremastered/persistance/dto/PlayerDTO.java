package com.restAPIremastered.persistance.dto;

public class PlayerDTO {

    private String firstName;
    private String lastName;
    private double grade;

    public PlayerDTO() {
        // Default constructor
    }
    public PlayerDTO(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "PlayerDTO [firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + "]";
    }
}