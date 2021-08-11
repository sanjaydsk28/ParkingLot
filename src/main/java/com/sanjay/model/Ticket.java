package com.sanjay.model;

public class Ticket {
    private String ticketId;

    Ticket(Floor floor, ParkingSlot parkingSlot) {
        StringBuilder sb = new StringBuilder();
        this.ticketId = sb.append("PR1234_").append(floor.toString()).append("_").append(parkingSlot.toString()).toString();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
