package com.alds.design.elevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.service.ElevatorService;

/**
 * @author rohsingh
 *
 */
public class ElevatorController {
    
    private static final int DEAFULT_NUMBER_OF_ELEVATOR = 1;
    
    List<Elevator> elevators;
    ElevatorService elevatorService;

    public ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
        this.elevators = new ArrayList<>();
        elevators.add(new Elevator(DEAFULT_NUMBER_OF_ELEVATOR));
    }
    
    public ElevatorController(ElevatorService elevatorService, int elevatorsToInit) {
        this.elevatorService = elevatorService;
        this.elevators = new ArrayList<>();
        IntStream.range(1, elevatorsToInit).forEach(i-> elevators.add(new Elevator(i)));
    }
    

}
