package com.sanjay;

import com.sanjay.command.CommandExecutorFactory;
import com.sanjay.mode.InteractiveMode;
import com.sanjay.service.ParkingLotService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final PrintOutput printOutput = new PrintOutput();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        new InteractiveMode(commandExecutorFactory,printOutput).process();
    }
}
