/**
 * 
 */
package com.alds.design.elevator.controller;

import java.util.concurrent.atomic.AtomicBoolean;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorCommand;
import com.alds.design.elevator.model.ElevatorDirection;

/**
 * @author rohsi
 *
 */
public class ElevatorRunner extends Thread {

	private Elevator elevator;

	public ElevatorRunner(Elevator elevator) {
		this.elevator = elevator;
	}

	private AtomicBoolean keepRunning = new AtomicBoolean(true);

	@Override
	public void run() {
		while(keepRunning.get() == true) {
			while(getTotalCommands() > 0) {
				moveAndCheckIfServed();
			}
		}
	}

	public void stopElevator() {
		this.keepRunning.set(false);
	}
	
	public int getTotalCommands() {
		return this.elevator.getUpCommands().size() + this.elevator.getDownCommands().size();
	}

	public void addNewCommand(ElevatorCommand destination) {
		if (destination.getTargetFloor() > this.elevator.getCurrentFloor()) {
			this.elevator.getUpCommands().add(destination);
		} else {
			this.elevator.getDownCommands().add(destination);
		}
	}

	public boolean moveAndCheckIfServed() {
		if (this.elevator.getDirection() == ElevatorDirection.NONE) {
			if (this.elevator.getUpCommands().size() > 0 && this.elevator.getDownCommands().size() > 0) {
				if (Math.abs(this.elevator.getCurrentFloor() - this.elevator.getUpCommands().first().getTargetFloor()) < 
						Math.abs(this.elevator.getCurrentFloor() - this.elevator.getDownCommands().first().getTargetFloor())) {
					this.elevator.setDirection(ElevatorDirection.UP);
				} else {
					this.elevator.setDirection(ElevatorDirection.DOWN);
				}
			} else if (this.elevator.getUpCommands().size() > 0) {
				this.elevator.setDirection(ElevatorDirection.UP);
			} else if (this.elevator.getDownCommands().size() > 0) {
				this.elevator.setDirection(ElevatorDirection.DOWN);
			}
		}

		if(this.elevator.getDirection() == ElevatorDirection.UP){
			if(this.elevator.getUpCommands().first().getTargetFloor() == this.elevator.getCurrentFloor()){
				this.elevator.getUpCommands().pollFirst();
				return true;
			}else {
				this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() + 1);
			}
		}else if(this.elevator.getDirection() == ElevatorDirection.DOWN){
			if(this.elevator.getDownCommands().first().getTargetFloor() == this.elevator.getCurrentFloor()){
				this.elevator.getDownCommands().pollFirst();
				return true;
			} else {
				this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() - 1);
			}
		}else{
			//Do Nothing. Elevator is not moving.
		}
		return false;
	}


}
