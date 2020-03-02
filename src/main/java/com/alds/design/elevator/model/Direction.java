package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public enum Direction {
    
    UP(1),
    DOWN(-1);
	
	int direction;
	
	Direction(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}
	
	

}
