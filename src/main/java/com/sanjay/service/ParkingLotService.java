package com.sanjay.service;

import com.sanjay.exception.ParkingLotException;
import com.sanjay.model.ParkingLot;
import com.sanjay.model.ParkingSlot;
import com.sanjay.model.Vehicle;
import com.sanjay.model.parking.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(final ParkingLot parkingLot, final ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotException("Parking Lot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(final Vehicle vehicle) {
        validateParkingLotExists();
        final Integer nextFreeSlot = parkingStrategy.getNextSlot();
        parkingLot.park(vehicle, nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) {
            throw new ParkingLotException("Parking Lot doesn't exists");
        }
    }

    public void makeSlotFree(final Integer slotNumber) {
        validateParkingLotExists();
        parkingLot.makeSlotFree(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public List<ParkingSlot> getOccupiedSlots() {
        validateParkingLotExists();
        final List<ParkingSlot> occupiedSlots = new ArrayList<>();
        final Map<Integer, ParkingSlot> allSlots = parkingLot.getSlots();

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            if (allSlots.containsKey(i)) {
                final ParkingSlot slot = allSlots.get(i);
                if (!slot.isSlotAvailable()) {
                    occupiedSlots.add(slot);
                }
            }
        }
        return occupiedSlots;
    }

    public List<ParkingSlot> getFreeSlots() {
        validateParkingLotExists();
        final List<ParkingSlot> freeSlots = new ArrayList<>();
        final Map<Integer, ParkingSlot> allSlots = parkingLot.getSlots();

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            if (allSlots.containsKey(i)) {
                final ParkingSlot slot = allSlots.get(i);
                if (slot.isSlotAvailable()) {
                    freeSlots.add(slot);
                }
            }
        }
        return freeSlots;
    }
}
