package com.sanjay;

public class PrintOutput {

    public void welcome() {printWithNewLine("Welcome to Parking Lot");}

    public void end() {
        printWithNewLine("Exited the parking lot");
    }

    public void printWithNewLine(String output) {
        System.out.println(output);
    }

    public void parkingLotFull() {
        printWithNewLine("Parking Lot is Full");
    }
}
