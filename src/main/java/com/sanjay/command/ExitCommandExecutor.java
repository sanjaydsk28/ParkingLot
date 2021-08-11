package com.sanjay.command;

import com.sanjay.PrintOutput;
import com.sanjay.model.Command;
import com.sanjay.service.ParkingLotService;

public class ExitCommandExecutor extends CommandExecutor {
    public final static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(final ParkingLotService parkingLotService, final PrintOutput printOutput) {
        super(parkingLotService, printOutput);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public boolean execute(Command command) {
        if (!validate(command)) {
            return false;
        }
        printOutput.end();
        return true;
    }
}
