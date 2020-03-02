package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public class ElevatorCommand {
	
	private int userId;
	private int level;
	
	public ElevatorCommand(int level) {
		super();
		this.level = level;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLevel() {
		return level;
	}

}
