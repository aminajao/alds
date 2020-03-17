package com.alds.design.elevator.model;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author rohsingh
 * 
 	 Elevator service algorithm:
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
public class Elevator {

	final int elevatorId;
	int currentFloor;
	ElevatorStatus status;
	ElevatorDirection direction;
	ConcurrentSkipListSet<ElevatorCommand> upCommands;
	ConcurrentSkipListSet<ElevatorCommand> downCommands;

	public Elevator() {
		this(1);
	}

	public Elevator(int elevatorId) {
		this(elevatorId, ElevatorStatus.IDLE);
	}

	public Elevator(int elevatorId, ElevatorStatus status) {
		this.elevatorId = elevatorId;
		this.status = status;
		this.upCommands = new ConcurrentSkipListSet<>();
		this.downCommands = new ConcurrentSkipListSet<>(new Comparator<ElevatorCommand>() {
			public int compare(ElevatorCommand o1, ElevatorCommand o2) {
				return o2.compareTo(o1);
			}
		});
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public void setDirection(ElevatorDirection direction) {
		this.direction = direction;
	}

	public ElevatorStatus getStatus() {
		return status;
	}

	public void setStatus(ElevatorStatus status) {
		this.status = status;
	}

	public int getElevatorId() {
		return elevatorId;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public ConcurrentSkipListSet<ElevatorCommand> getUpCommands() {
		return upCommands;
	}

	public ConcurrentSkipListSet<ElevatorCommand> getDownCommands() {
		return downCommands;
	}

	
}
