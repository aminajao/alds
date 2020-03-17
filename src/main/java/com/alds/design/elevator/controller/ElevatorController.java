package com.alds.design.elevator.controller;

import java.util.ArrayList;
import java.util.List;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorStatus;

/**
 * @author rohsingh
 *
 */
public class ElevatorController {

	private static final int MAX_ELEVATORS = 8;

	final List<ElevatorRunner> elevators;
	
	final int elevatorCount;
	
	public ElevatorController(int elevatorCount) {
		System.out.println("Elevator System starting..");
		this.elevatorCount = elevatorCount < MAX_ELEVATORS ? elevatorCount : MAX_ELEVATORS;
		this.elevators = new ArrayList<>();
		for(int elevator = 1; elevator <= elevatorCount; elevator++){
            Elevator e = new Elevator(elevator, ElevatorStatus.IDLE);
            ElevatorRunner runner = new ElevatorRunner(e);
            System.out.println("Started Elevator "+e.getElevatorId());
            runner.start();
        }
		System.out.println("Elevator System started..");
	}

	public List<ElevatorRunner> getElevators() {
		return elevators;
	}

	public int getElevatorCount() {
		return elevatorCount;
	}
}
