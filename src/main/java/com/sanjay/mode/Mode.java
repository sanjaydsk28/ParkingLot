package com.sanjay.mode;

import com.sanjay.PrintOutput;
import com.sanjay.command.CommandExecutor;
import com.sanjay.command.CommandExecutorFactory;
import com.sanjay.exception.InvalidCommandException;
import com.sanjay.model.Command;

import java.io.IOException;

public abstract class Mode {
    private CommandExecutorFactory commandExecutorFactory;
    protected PrintOutput printOutput;

    public Mode(final CommandExecutorFactory commandExecutorFactory, final PrintOutput printOutput) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.printOutput = printOutput;
    }

    public void executeCommand(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);

        if (commandExecutor.execute(command) == false) {
            throw new InvalidCommandException();
        }
    }

    public abstract void process() throws IOException;
}
