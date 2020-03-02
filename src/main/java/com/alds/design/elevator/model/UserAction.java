package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public class UserAction {
	
	private int userId;
	private Direction direction;
	private int level;
	private int elevatorId;
	
	public UserAction(Direction direction, int level, int elevatorId) {
		super();
		this.direction = direction;
		this.level = level;
		this.elevatorId = elevatorId;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getLevel() {
		return level;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getElevatorId() {
		return elevatorId;
	}
}
