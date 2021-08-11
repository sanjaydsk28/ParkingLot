package com.sanjay.command;

import com.sanjay.PrintOutput;
import com.sanjay.model.Command;
import com.sanjay.model.parking.strategy.ParkingStrategy;
import com.sanjay.service.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected PrintOutput printOutput;

    public CommandExecutor(final ParkingLotService parkingLotService, final PrintOutput printOutput) {
        this.parkingLotService = parkingLotService;
        this.printOutput = printOutput;
    }

    public abstract boolean validate(Command command);

    public abstract boolean execute(Command command);
}
