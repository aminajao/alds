package com.alds.design.elevator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorCommand;
import com.alds.design.elevator.model.Status;

/**
 * @author rohsingh
 *
 */
public class ElevatorService {

	List<Elevator> elevators;

	public ElevatorService() {
		this.elevators = new ArrayList<>();
	}

	public void addElevator(Elevator elevator) {
		this.elevators.add(elevator);
	}

	public List<Elevator> getElevators() {
		return elevators;
	}

	public Elevator getElevator(int id) {
		return elevators.stream().filter(el -> (el.getElevatorId() == id)).findFirst().orElse(null);
	}

	public void processCommand() {
		List<ElevatorCommand> commandsToProcess = 
				elevators.stream()
				.filter(el -> Status.REPAIR != el.getStatus())
				.map(el -> el.getCommands()).flatMap(Set::stream)
				.collect(Collectors.toList());

		if (!commandsToProcess.isEmpty()) {

		}
	}

}
