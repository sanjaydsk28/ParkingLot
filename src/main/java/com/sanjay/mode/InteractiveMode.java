package com.sanjay.mode;

import com.sanjay.PrintOutput;
import com.sanjay.command.CommandExecutorFactory;
import com.sanjay.command.ExitCommandExecutor;
import com.sanjay.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{
    public InteractiveMode(CommandExecutorFactory commandExecutorFactory, final PrintOutput printOutput) {
        super(commandExecutorFactory, printOutput);
    }

    @Override
    public void process() throws IOException {
        printOutput.welcome();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            executeCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
