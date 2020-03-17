package com.alds.design.elevator;

import java.util.concurrent.ThreadLocalRandom;

import com.alds.design.elevator.controller.ElevatorController;
import com.alds.design.elevator.service.ElevatorService;

/**
 * @author rohsingh
 *
 */
public class ElevatorMain {

	public static void main(String[] args) {
		ElevatorController controller = new ElevatorController(new ElevatorService(2));
		new Thread(() ->  {
			while(true) {
				try {
					controller.sendFloorRequest(ThreadLocalRandom.current().nextInt(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() ->  {
			while(true) {
				try {
					controller.consumeFloorRequest();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
