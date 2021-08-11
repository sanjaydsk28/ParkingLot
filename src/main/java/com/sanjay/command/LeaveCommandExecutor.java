package com.sanjay.command;

import com.sanjay.PrintOutput;
import com.sanjay.exception.NoFreeSlotAvailableException;
import com.sanjay.model.Command;
import com.sanjay.model.Vehicle;
import com.sanjay.service.ParkingLotService;

public class LeaveCommandExecutor extends CommandExecutor {
    public final static String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(ParkingLotService parkingLotService, PrintOutput printOutput) {
        super(parkingLotService, printOutput);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public boolean execute(Command command) {
        if (!validate(command)) return false;
        final Integer slot = Integer.parseInt(command.getParams().get(0));
        parkingLotService.makeSlotFree(slot);
        printOutput.printWithNewLine("Slot Number: " + slot + " is free");
        return true;
    }
}
