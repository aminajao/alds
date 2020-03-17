package com.alds.design.elevator.model;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author rohsingh
 *
 */
public class Elevator {

	final int elevatorId;
	int currentFloor;
	ElevatorStatus status;
	ElevatorDirection direction;
	ConcurrentSkipListSet<Integer> upFloorRequests;
	ConcurrentSkipListSet<Integer> downFloorRequests;

	public Elevator() {
		this(1);
	}

	public Elevator(int elevatorId) {
		this(elevatorId, 0);
	}

	public Elevator(int elevatorId, int currentFloor) {
		this.elevatorId = elevatorId;
		this.currentFloor = currentFloor;
		this.direction = ElevatorDirection.NONE;
		this.status = ElevatorStatus.IDLE;
		this.upFloorRequests = new ConcurrentSkipListSet<>();
		this.downFloorRequests = new ConcurrentSkipListSet<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
	}

	public boolean updateStatus(ElevatorStatus elevatorStatus){
		if(getTotalFloorRequests() > 0){
			return false;
		}
		status = elevatorStatus;
		return true;
	}

	public int getNextFloorDestination(){
		if(direction == ElevatorDirection.DOWN){
			return downFloorRequests.first();
		}else if(direction == ElevatorDirection.UP){
			return upFloorRequests.first();
		}else{
			return 0;
		}
	}

	public void addNewFloorRequest(int newFloor) {
		if (newFloor > currentFloor) {
			upFloorRequests.add(newFloor);
		} else {
			downFloorRequests.add(newFloor);
		}
		System.out.println("Added Request For Elevator : "+elevatorId+ " Up : "+upFloorRequests.size()+" Down : "+downFloorRequests.size());
	}

	public boolean moveAndCheckIfServed() {
		if (direction== ElevatorDirection.NONE) {
			if (upFloorRequests.size() > 0 && downFloorRequests.size() > 0) {
				if (Math.abs(currentFloor - upFloorRequests.first()) < Math.abs(currentFloor - downFloorRequests.first())) {
					direction = ElevatorDirection.UP;
				} else {
					direction = ElevatorDirection.DOWN;
				}
			} else if (upFloorRequests.size() > 0) {
				direction = ElevatorDirection.UP;
			} else if (downFloorRequests.size() > 0) {
				direction = ElevatorDirection.DOWN;
			}
		}

		if(direction == ElevatorDirection.UP){
			if(upFloorRequests.first() == currentFloor){
				upFloorRequests.pollFirst();
				return true;
			}else {
				currentFloor++;
			}
		}else if(direction == ElevatorDirection.DOWN){
			if(downFloorRequests.first() == currentFloor){
				downFloorRequests.pollFirst();
				return true;
			} else {
				currentFloor--;
			}
		}else{
			//Do Nothing. Elevator is not moving.
		}
		return false;
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public ElevatorStatus getStatus() {
		return status;
	}

	public int getElevatorId() {
		return elevatorId;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getTotalFloorRequests() {
		return upFloorRequests.size() + downFloorRequests.size();
	}

}
