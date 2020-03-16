/**
 * 
 */
package com.alds.design.elevator.processor;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

import com.alds.design.elevator.model.ElevatorCommand;

/**
 * @author rohsi
 *
 */
public class ElevatorQueue {
	
	private final int capacity;
	
	private final LinkedList<ElevatorCommand> commands;
	
	private final ReentrantLock lock = new ReentrantLock();
	
	public ElevatorQueue() {
		this.commands = new LinkedList<>();
		this.capacity = 50;
	}
	
	public void put(ElevatorCommand command) {
		lock.lock();
		try {
			this.commands.add(command);
		} finally {
			lock.unlock();
		}
	}
	
	public ElevatorCommand take() {
		lock.lock();
		try {
			return this.commands.remove();
		} finally {
			lock.unlock();
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public LinkedList<ElevatorCommand> getCommands() {
		return commands;
	}
	

}
