package com.wolfe.transport;

public class Boat extends Vehicle implements Steerable{
	
	
	protected String color;
	protected double hullLengthInMeters;
	protected boolean hasHoleinHull;
	
	
	public Boat() {
		super();
	}


	@Override
	public String toString() {
		return "Boat [color=" + color + ", hullLengthInMeters=" + hullLengthInMeters + "]";
	}


	public Boat(String color, double hullLengthInMeters, boolean hasHoleinHull) {
		super();
		this.color = color;
		this.hullLengthInMeters = hullLengthInMeters;
		this.hasHoleinHull = hasHoleinHull;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getHullLengthInMeters() {
		return hullLengthInMeters;
	}


	public void setHullLengthInMeters(double hullLengthInMeters) {
		this.hullLengthInMeters = hullLengthInMeters;
	}


	public boolean isHasHoleinHull() {
		return hasHoleinHull;
	}


	public void setHasHoleinHull(boolean hasHoleinHull) {
		this.hasHoleinHull = hasHoleinHull;
	}


	@Override
	public void move() {
		
		System.out.println("The Boat is Moving");
	}


	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		System.out.println("paddle right");
	}


	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		System.out.println("paddle left");
	}

}
