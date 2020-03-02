package com.alds.design.elevator.model;

import java.util.Set;

/**
 * @author rohsingh
 *
 */
public class Elevator {

	private int elevatorId;
	private Direction direction;
	private Status status;
	private int targetLevel;
	private Set<ElevatorCommand> commands;

	public Elevator(int elevatorId) {
		this.elevatorId = elevatorId;
		this.status = Status.IDLE;
	}

	public Elevator(int elevatorId, Status status) {
		this.elevatorId = elevatorId;
		this.status = status;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public Set<ElevatorCommand> getCommands() {
		return commands;
	}

	public void addCommand(ElevatorCommand command) {
		this.commands.add(command);
	}

}
