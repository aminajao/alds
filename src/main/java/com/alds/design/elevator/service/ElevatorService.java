package com.alds.design.elevator.service;

import java.util.HashSet;
import java.util.Set;

import com.alds.design.elevator.model.ElevatorCommand;

/**
 * @author rohsingh
 *
 */
public class ElevatorService {
    
    Set<ElevatorCommand> commands;

    public ElevatorService() {
        this.commands = new HashSet<>();
    }

    public Set<ElevatorCommand> getCommands() {
        return commands;
    }
    
    public void addCommand(ElevatorCommand command) {
        this.commands.add(command);
    }
    
    public void processCommand() {
    	if(!commands.isEmpty()) {
    		// write core processing logic here
    	}
    }
    
}
