package com.alds.design.elevator.controller;

import java.util.ArrayList;
import java.util.List;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorStatus;

/**
 * @author rohsingh
 * 
 * 
 	Elevator Scheduling Algorithm:
    ---------------------------
    -> Upper bound of active requests per elevator (Average per elevator) = activeRequests/elevatorCount + 1
    -> Do not assign the request to an elevator if it is under MAINTENANCE or is already serving more than average number of active requests in the system.
    -> Now, among all elevators excluding above ones, find the closest elevator moving in direction of request or is IDLE.
        -> Case I -     There are 2 elevators - 1 above the requestFloor coming down and 1 below the requestFloor which is coming up:
                        Assign the request to the closest of these 2.
                        return true
        -> Case II -    There is only 1 elevator moving towards the requestFloor:
                        Assign the request to the given elevator.
                        return true
        -> Case III -   No elevators were found eligible to serve the request. Can happen if all the elevators are under MAINTENANCE
                        return false as we could not schedule the request to any of the elevators in the system.
 *
 */
public class ElevatorController {

	private static final int MAX_ELEVATORS = 8;

	final List<ElevatorRunner> elevators;
	
	final int elevatorCount;
	
	public ElevatorController(int elevatorCount) {
		System.out.println("Elevator System starting..");
		this.elevatorCount = elevatorCount < MAX_ELEVATORS ? elevatorCount : MAX_ELEVATORS;
		this.elevators = new ArrayList<>();
		for(int elevator = 1; elevator <= elevatorCount; elevator++){
            Elevator e = new Elevator(elevator, ElevatorStatus.IDLE);
            ElevatorRunner runner = new ElevatorRunner(e);
            System.out.println("Started Elevator "+e.getElevatorId());
            runner.start();
        }
		System.out.println("Elevator System started..");
	}

	public List<ElevatorRunner> getElevators() {
		return elevators;
	}

	public int getElevatorCount() {
		return elevatorCount;
	}
}
