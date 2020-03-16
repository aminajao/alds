package com.alds.design.elevator.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rohsingh
 *
 */
public class Elevator {

	private int elevatorId;
	private ElevatorDirection direction;
	private ElevatorStatus status;
	private int targetLevel;
	private ConcurrentHashMap<ElevatorCommand, Elevator> commandMap;
	
	public Elevator() {
		this(1);
	}
	
	public Elevator(int elevatorId) {
		this(elevatorId, ElevatorStatus.IDLE);
	}

	public Elevator(int elevatorId, ElevatorStatus status) {
		this.elevatorId = elevatorId;
		this.status = status;
		this.commandMap = new ConcurrentHashMap<>();
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

	public int getTargetLevel() {
		return targetLevel;
	}

	public void setTargetLevel(int targetLevel) {
		this.targetLevel = targetLevel;
	}

	public void addCommand(ElevatorCommand command) {
		this.commandMap.put(command, this);
	}

	public ConcurrentHashMap<ElevatorCommand, Elevator> getCommandMap() {
		return commandMap;
	}

}
