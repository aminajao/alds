package com.alds.design.elevator.model;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author rohsingh
 *
 */
public class Elevator {

	final int elevatorId;
	int currentFloor;
	ElevatorStatus status;
	ElevatorDirection direction;
	ConcurrentSkipListSet<ElevatorCommand> upCommands;
	ConcurrentSkipListSet<ElevatorCommand> downCommands;

	public Elevator() {
		this(1);
	}

	public Elevator(int elevatorId) {
		this(elevatorId, ElevatorStatus.IDLE);
	}

	public Elevator(int elevatorId, ElevatorStatus status) {
		this.elevatorId = elevatorId;
		this.status = status;
		this.upCommands = new ConcurrentSkipListSet<>();
		this.downCommands = new ConcurrentSkipListSet<>(new Comparator<ElevatorCommand>() {
			public int compare(ElevatorCommand o1, ElevatorCommand o2) {
				return o2.compareTo(o1);
			}
		});
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public void setDirection(ElevatorDirection direction) {
		this.direction = direction;
	}

	public ElevatorStatus getStatus() {
		return status;
	}

	public void setStatus(ElevatorStatus status) {
		this.status = status;
	}

	public int getElevatorId() {
		return elevatorId;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public ConcurrentSkipListSet<ElevatorCommand> getUpCommands() {
		return upCommands;
	}

	public ConcurrentSkipListSet<ElevatorCommand> getDownCommands() {
		return downCommands;
	}

	
}
