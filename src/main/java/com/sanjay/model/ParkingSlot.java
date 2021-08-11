package com.sanjay.model;

public class ParkingSlot {
    private int slotNumber;
    private Vehicle vehicle;

    public ParkingSlot(final int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isSlotAvailable() {
        return vehicle == null;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unassignVehicle() {
        this.vehicle = null;
    }

    @Override
    public String toString() {
        return Integer.toString(getSlotNumber());
    }
}
