/**
 * 
 */
package com.alds.design.elevator.processor;

import java.util.concurrent.atomic.AtomicBoolean;

import com.alds.design.elevator.model.Elevator;
import com.alds.design.elevator.model.ElevatorCommand;
import com.alds.design.elevator.model.ElevatorStatus;

/**
 * @author rohsi
 *
 */
public class ElevatorThread extends Thread {

	private Elevator elevator;

	public ElevatorThread(int id, ElevatorStatus status) {
		this.elevator = new Elevator(id, status);
	}

	private AtomicBoolean keepRunning = new AtomicBoolean(true);

	@Override
	public void run() {
		while (keepRunning.get() == true) {
			while (elevator.getCommandMap().size() > 0) {
				elevator.getCommandMap().entrySet().stream().forEach(entry -> {
					ElevatorCommand elCommand = entry.getKey();
					Elevator el = entry.getValue();
					if (el.getTargetLevel() < 1 || el.getTargetLevel() < elCommand.getLevel()) {
						el.setTargetLevel(elCommand.getLevel());
					} else {
						//
					}
					System.out.println("Elevator reaching to level : " + el.getTargetLevel());
				});
			}
		}
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void stopElevator() {
		this.keepRunning.set(false);
	}

}
