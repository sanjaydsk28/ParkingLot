package com.sanjay.command;

import com.sanjay.PrintOutput;
import com.sanjay.exception.NoFreeSlotAvailableException;
import com.sanjay.model.Command;
import com.sanjay.model.Vehicle;
import com.sanjay.service.ParkingLotService;

public class ParkComomandExecutor extends CommandExecutor {
    public final static String COMMAND_NAME = "park";

    public ParkComomandExecutor(ParkingLotService parkingLotService, PrintOutput printOutput) {
        super(parkingLotService, printOutput);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public boolean execute(Command command) {
        if (!validate(command)) return false;

        final Vehicle vehicle = new Vehicle(command.getParams().get(0), command.getParams().get(1));
        try {
           final Integer slot = parkingLotService.park(vehicle);
           printOutput.printWithNewLine("Allocated Slot Number: " + slot);
        } catch (NoFreeSlotAvailableException exception) {
            printOutput.parkingLotFull();
        }
        return true;
    }
}
