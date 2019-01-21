package com.revature.transport;

import com.revature.transport.Vehicle;

public class Tornado extends Vehicle {

	public Tornado(double maxWindSpeed) {
		super();
		this.maxWindSpeed = maxWindSpeed;
	}

	public Tornado() {
	}
	
	private double maxWindSpeed;
	private boolean isInSuperCell; //hooray for weather

	@Override
	public void move() throws MaintenanceException{
		if (!this.isInSuperCell) {
			throw new MaintenanceException("weather machine incorrectly configured");
		}
		
		System.out.println("DESTROYING THE CITY");
	}

	public double getMaxWindSpeed() {
		return maxWindSpeed;
	}

	public void setMaxWindSpeed(double maxWindSpeed) {
		this.maxWindSpeed = maxWindSpeed;
	}

	@Override
	public String toString() {
		return "Tornado [maxWindSpeed=" + maxWindSpeed + "]";
	}

}
