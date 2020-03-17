package com.alds.design.elevator.model;

import java.util.Objects;

/**
 * @author rohsingh
 *
 */
public class ElevatorCommand implements Comparable<ElevatorCommand> {
	 
	private int userId;
	private int targetFloor;
	private ElevatorDirection targetDirection;
	
	public ElevatorCommand(int level) {
		this.targetFloor = level;
	}
	
	public ElevatorCommand(UserAction action) {
		this.userId = action.getUserId();
		this.targetFloor = action.getLevel();
		this.targetDirection = action.getDirection();
	}

	public int getUserId() {
		return userId;
	}

	public int getTargetFloor() {
		return targetFloor;
	}

	public ElevatorDirection getDirection() {
		return targetDirection;
	}

	@Override
	public int hashCode() {
		return Objects.hash(targetFloor, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ElevatorCommand))
			return false;
		ElevatorCommand other = (ElevatorCommand) obj;
		return targetFloor == other.targetFloor && userId == other.userId;
	}

	@Override
	public int compareTo(ElevatorCommand o) {
		return Integer.compare(this.targetFloor, o.targetFloor);
	}

}
