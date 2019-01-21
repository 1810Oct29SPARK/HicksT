package com.wolfe.transport;

public class Car extends Vehicle implements Steerable{
	
	
	public static final int recommendedMiBtwnOilChanges = 5000;
	
	private int yearManufactured;
	private String model;
	private String make;
	private transient double milesSinceOilChange;
	
	public Car(int yearManufactured, String model, String make, double milesSinceOilChange) {
		super();
		this.yearManufactured = yearManufactured;
		this.model = model;
		this.make = make;
		this.milesSinceOilChange = milesSinceOilChange;
	}
	
	public Car() {
		super();
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

	public static int getRecommendedmibtwnoilchanges() {
		return recommendedMiBtwnOilChanges;
	}

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", model=" + model + ", make=" + make
				+ ", milesSinceOilChange=" + milesSinceOilChange + "]";
	}

	@Override
	public void move() {
		System.out.println("Car is Moving");
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		System.out.println("turn wheel clockwise");
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		System.out.println("Turn wheel counter-clockwise");
	}
	
	
	
	
}

