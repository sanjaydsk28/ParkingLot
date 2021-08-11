package com.sanjay.model;

import java.util.List;

public class Floor {
    private int id;
    private List<ParkingSlot> parkingSlotList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    @Override
    public String toString() {
        return Integer.toString(getId());
    }
}
