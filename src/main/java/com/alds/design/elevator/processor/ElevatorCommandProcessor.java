/**
 * 
 */
package com.alds.design.elevator.processor;

import java.util.ArrayList;
import java.util.List;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorCommand;

/**
 * @author rohsi
 *
 */
public class ElevatorCommandProcessor {
	
	ElevatorQueue elevatorQueue;
	
	List<ElevatorThread> elevators;
	
	public ElevatorCommandProcessor() {
		this.elevatorQueue = new ElevatorQueue();
		this.elevators = new ArrayList<>();
	}
	
	public void processCommand() {
		ElevatorCommand command = this.elevatorQueue.take();
		if(command.getDirection() != null) {
			elevators.stream()
			// assume the logic of elevator selection on direction
			.filter(el -> el.getElevator().getDirection() == command.getDirection())
			.findFirst()
			.ifPresent(el -> el.getElevator().addCommand(command));
		}
	}

	public Elevator getElevator(int id) {
		return elevators.stream().map(ElevatorThread::getElevator).filter(el -> (el.getElevatorId() == id)).findFirst().orElse(null);
	}

	public ElevatorQueue getElevatorQueue() {
		return elevatorQueue;
	}
	
	public List<ElevatorThread> getElevators() {
		return elevators;
	}

}
