package com.alds.design.elevator.controller;

import java.util.stream.IntStream;

import com.alds.design.elevator.model.ElevatorStatus;
import com.alds.design.elevator.processor.ElevatorCommandProcessor;
import com.alds.design.elevator.processor.ElevatorThread;

/**
 * @author rohsingh
 *
 */
public class ElevatorController {

	private static final int DEAFULT_NUMBER_OF_ELEVATOR = 1;

	ElevatorCommandProcessor elevatorCommandProcessor;
	
	int elevatorsToInit;

	public ElevatorController(ElevatorCommandProcessor elevatorCommandProcessor, int elevatorsToInit) {
		this.elevatorCommandProcessor = elevatorCommandProcessor;
		this.elevatorsToInit = elevatorsToInit;
	}
	
	public ElevatorController(ElevatorCommandProcessor elevatorCommandProcessor) {
		this(elevatorCommandProcessor, DEAFULT_NUMBER_OF_ELEVATOR);
	}

	public void start() {
		System.out.println("Elevator System starting..");
		IntStream.range(1, elevatorsToInit).forEach(i -> {
			ElevatorThread elevT = new ElevatorThread(i, ElevatorStatus.IDLE);
			elevatorCommandProcessor.getElevators().add(elevT);			
		});
		System.out.println("Elevator System started..");
	}
}
