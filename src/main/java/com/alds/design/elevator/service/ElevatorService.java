package com.alds.design.elevator.service;

import com.alds.design.elevator.model.ElevatorCommand;

/**
 * @author rohsingh
 *
 */
public class ElevatorService {
    
    ElevatorCommand command;

    public ElevatorService(ElevatorCommand command) {
        this.command = command;
    }
    
}
