package com.wolfe.transport;

//


public abstract class Vehicle {
	
	public Vehicle() {
		super();
		System.out.println("Vehicle Constructor Completed");
	}
	
	public abstract void move();
}
