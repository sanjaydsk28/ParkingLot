package com.sanjay.model;

public class Vehicle {
    private String registrationNumber;
    private Color color;

    public Vehicle(String registrationNumber, Color color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public Vehicle(String registrationNumber, String s) {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
