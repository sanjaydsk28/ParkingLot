package com.sanjay.model;

public enum Color {
    BLACK("black"),
    BLUE("blue"),
    GREEN("green"),
    GRAY("gray"),
    WHITE("white");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
