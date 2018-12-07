package com.revature.transport;

import java.io.Serializable;

public class Car extends Vehicle implements Steerable, Comparable<Car>, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3345436473318002160L;

	public Car(int yearManufactured, String model, String make, double milesSinceOilChange) {
		super();
		this.yearManufactured = yearManufactured;
		this.model = model;
		this.make = make;
		this.milesSinceOilChange = milesSinceOilChange;
	}

	public Car() {
		super(); // calls Vehicle()
	}

	public static int recommendedMiBtwnOilChanges = 5000;
	
	private int yearManufactured;
	private String model;
	private String make;
	private transient double milesSinceOilChange;

	@Override
	public void move() throws MaintenanceException{
		
		if (this.milesSinceOilChange >= recommendedMiBtwnOilChanges) {
			throw new MaintenanceException("Oil needs to be Changed");
		}
		System.out.println("car is moving");
	}

	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getMilesSinceOilChange() {
		return milesSinceOilChange;
	}

	public void setMilesSinceOilChange(double milesSinceOilChange) {
		this.milesSinceOilChange = milesSinceOilChange;
	}

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", model=" + model + ", make=" + make
				+ ", milesSinceOilChange=" + milesSinceOilChange + "]";
	}

	@Override
	public void turnRight() {
		System.out.println("turn wheel clockwise");
	}

	@Override
	public void turnLeft() {
		System.out.println("turn wheel counterclockwise");
	}

	@Override
	public int compareTo(Car o) {
		return this.model.compareTo(o.getMake())+this.model.compareTo(o.getModel());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		long temp;
		temp = Double.doubleToLongBits(milesSinceOilChange);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + yearManufactured;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (Double.doubleToLongBits(milesSinceOilChange) != Double.doubleToLongBits(other.milesSinceOilChange))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (yearManufactured != other.yearManufactured)
			return false;
		return true;
	}

	

}