package com.revature.service;

public abstract class AnimalService {
	protected int speed;

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public AnimalService() {

	}

	public abstract int getSpeed();

	public abstract Boolean isFull();

	public abstract void setFull(Boolean full);

	public abstract void animalChasesYou();

	public void animalCatchesYou() {
		System.out.println("Hope Its not Hungry!");
	}
}
