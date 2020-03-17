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
 *  	 
 *  Elevator service algorithm:
     ---------------------------
     -> It can happen that an elevator is on its way from floor 1 to floor 10 and while its is at floor 5, elevator got a pickUp request for floor 8.
        In this case, we should stop the elevator at floor 8 first and then proceed to floor 10. So a simple FCFS algorithm in elevator service queue will not work.
     -> Each elevator maintains 2 sets of floors to be serviced.
        -> 1 TreeSet for all pickUp requests from floors above the getCurrentFloor in ascending order.
        -> 1 TreeSet for all pickUp requests from floors below the getCurrentFloor in descending order.
        -> TreeSet also helps avoid duplicate requests.
     -> When an elevator moves:
        -> Case I       -> Elevator was in NONE state which means elevator hasn't serviced any request yet or was done servicing all previous requests in the direction of its move.
                        -> Start servicing the request in the direction which has closest requestFloor and set the direction as UP or DOWN based on target floor's location.
        -> Case II      -> Elevator is moving UP:
                        -> Continue to move in this direction until all requestFloors above current floors are serviced.
                        -> When done servicing all above floors, reset the direction to NONE.
        -> Case III     -> Elevator is moving DOWN:
                        -> Continue to move in this direction until all requestFloors below current floors are serviced.
                        -> When done servicing all below floors, reset the direction to NONE.
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
