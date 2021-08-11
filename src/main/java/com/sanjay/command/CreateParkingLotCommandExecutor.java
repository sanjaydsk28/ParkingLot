package com.sanjay.command;

import com.sanjay.PrintOutput;
import com.sanjay.model.Command;
import com.sanjay.model.ParkingLot;
import com.sanjay.model.ParkingSlot;
import com.sanjay.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.sanjay.model.parking.strategy.ParkingStrategy;
import com.sanjay.service.ParkingLotService;
import com.sanjay.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService, final PrintOutput printOutput) {
        super(parkingLotService, printOutput);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }

        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public boolean execute(Command command) {
        if (validate(command) == false) return false;
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        printOutput.printWithNewLine("Created a parkingLot with " + parkingLot.getCapacity() + " slots");
        return true;
    }
}
