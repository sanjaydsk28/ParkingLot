package com.sanjay.model;


import com.sanjay.exception.InvalidSlotException;
import com.sanjay.exception.ParkingLotException;
import com.sanjay.exception.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int MAX_CAPACITY = 1000;
    private int capacity;
    private Map<Integer, ParkingSlot> slots;

    public int getCapacity() {
        return capacity;
    }

    public Map<Integer, ParkingSlot> getSlots() {
        return slots;
    }

    public void updateSlot(Integer slotNumber, ParkingSlot parkingSlot) {
        slots.put(slotNumber, parkingSlot);
    }

    public ParkingLot(int capacity) {
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new ParkingLotException("Invalid capacity given for Parking Lot.");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    public ParkingSlot getSlot(final Integer slotNumber) {
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new InvalidSlotException();
        }

        if (!getSlots().containsKey(slotNumber)) {
            updateSlot(slotNumber, new ParkingSlot(slotNumber));
        }

        return getSlots().get(slotNumber);
    }

    public ParkingSlot park(Vehicle vehicle, final Integer slotNumber) {
        final ParkingSlot slot = getSlot(slotNumber);
        if (!slot.isSlotAvailable()) {
            throw new SlotAlreadyOccupiedException();
        }

        slot.assignVehicle(vehicle);
        return slot;
    }

    public ParkingSlot makeSlotFree(final Integer slotNumber) {
        final ParkingSlot slot = getSlot(slotNumber);
        slot.unassignVehicle();
        return slot;
    }
}
