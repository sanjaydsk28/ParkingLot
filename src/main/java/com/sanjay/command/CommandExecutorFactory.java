package com.sanjay.command;

import com.sanjay.PrintOutput;
import com.sanjay.exception.InvalidCommandException;
import com.sanjay.model.Command;
import com.sanjay.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();

    public CommandExecutorFactory(ParkingLotService parkingLotService) {
        final PrintOutput printOutput = new PrintOutput();
        commandExecutorMap.put(CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, printOutput));
        commandExecutorMap.put(ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService, printOutput));
        commandExecutorMap.put(ParkComomandExecutor.COMMAND_NAME,
                new ParkComomandExecutor(parkingLotService, printOutput));
        commandExecutorMap.put(LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService, printOutput));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        System.out.println("command Name: " + command.getCommandName());
        final CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
