package com.alds.design.elevator;

import com.alds.design.elevator.controller.ElevatorController;
import com.alds.design.elevator.processor.ElevatorCommandProcessor;

/**
 * @author rohsingh
 *
 */
public class ElevatorRunner {

	public static void main(String[] args) {
		new ElevatorController(new ElevatorCommandProcessor()).start();
	}
}
