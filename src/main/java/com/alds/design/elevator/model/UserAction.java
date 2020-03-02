package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public class UserAction {
	
	private int userId;
	private Direction direction;
	private int level;
	
	public UserAction(Direction direction, int level) {
		super();
		this.direction = direction;
		this.level = level;
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
}
