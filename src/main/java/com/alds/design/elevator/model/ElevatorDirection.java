package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public enum ElevatorDirection {
    
    UP(1),
    DOWN(-1);
	
	int direction;
	
	ElevatorDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}
	
	

}
