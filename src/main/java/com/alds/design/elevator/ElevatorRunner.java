package com.alds.design.elevator;

import com.alds.design.elevator.controller.ElevatorController;
import com.alds.design.elevator.service.ElevatorService;

/**
 * @author rohsingh
 *
 */
public class ElevatorRunner {

	public static void main(String[] args) {
		ElevatorService elevatorService = new ElevatorService();
		ElevatorController controller = new ElevatorController(elevatorService);
		controller.start();
	}
}
