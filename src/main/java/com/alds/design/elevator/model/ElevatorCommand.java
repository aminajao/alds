package com.alds.design.elevator.model;

import java.util.Objects;

/**
 * @author rohsingh
 *
 */
public class ElevatorCommand {
	
	private int userId;
	private int level;
	private Direction direction;
	
	public ElevatorCommand(int level) {
		super();
		this.level = level;
	}
	
	public ElevatorCommand(UserAction action) {
		this.userId = action.getUserId();
		this.level = action.getLevel();
		this.direction = action.getDirection();
	}

	public int getUserId() {
		return userId;
	}

	public int getLevel() {
		return level;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(level, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ElevatorCommand))
			return false;
		ElevatorCommand other = (ElevatorCommand) obj;
		return level == other.level && userId == other.userId;
	}

}
