package com.alds.design.elevator.controller;

import java.util.stream.IntStream;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorCommand;
import com.alds.design.elevator.model.UserAction;
import com.alds.design.elevator.service.ElevatorService;

/**
 * @author rohsingh
 *
 */
public class ElevatorController {

	private static final int DEAFULT_NUMBER_OF_ELEVATOR = 1;

	ElevatorService elevatorService;

	public ElevatorController(ElevatorService elevatorService) {
		this.elevatorService = elevatorService;
		elevatorService.getElevators().add(new Elevator(DEAFULT_NUMBER_OF_ELEVATOR));
	}

	public ElevatorController(ElevatorService elevatorService, int elevatorsToInit) {
		this.elevatorService = elevatorService;
		IntStream.range(1, elevatorsToInit).forEach(i -> elevatorService.getElevators().add(new Elevator(i)));
	}

	public void executeUserAction(UserAction action) {
		if (action != null) {
			elevatorService.getElevator(action.getElevatorId()).addCommand(new ElevatorCommand(action));
		}
	}

	public void start() {
		System.out.println("Elevator System started..");
	}
}
