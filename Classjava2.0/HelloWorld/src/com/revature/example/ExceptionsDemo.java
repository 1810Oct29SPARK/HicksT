package com.revature.example;

import com.revature.transport.*;

public class ExceptionsDemo {

	public static void main(String[] args) {

		// Create New Car Object
		Car myCar = new Car(2021, "spaceship", "Tesla", 50);

		// inCar, ,change overridden move() from vehicle so that a MaintenanceException
		// can be thrown
		// if oil has not been changed recently

		// use a try-catch to handle potential exceptions
		try {
			myCar.move();
		} catch (MaintenanceException m) {
			m.printStackTrace();
		}

		// drive around for a bit
		myCar.setMilesSinceOilChange(5500);
		
		//try to restart car
		try {
			myCar.move();
		} catch (MaintenanceException m) {
			m.printStackTrace();
			//change the oil
			myCar.setMilesSinceOilChange(0);
			//try to move car again
			//you can Nest Try-catch. but be careful with this
			try {
				myCar.move();
			} catch (MaintenanceException e) {
				m.printStackTrace();
			}
		}
		
	}

}
