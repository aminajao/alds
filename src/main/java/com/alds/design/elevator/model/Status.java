package com.alds.design.elevator.model;

/**
 * @author rohsingh
 *
 */
public enum Status {

    IDLE(0),
    MOVING(1),
    REPAIR(-1);
	
	int status;
	
	Status(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
}
