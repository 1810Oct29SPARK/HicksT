package com.revature.vacation;

import com.revature.transport.*;
public class GoOnVacation {

	public static void main(String[] args) {

		Vehicle[] vehicles = {new Tornado(147.2),new Kayak("red",4.2,2,2),new Car(2021, "spaceship", "Tesla", 50), new Tornado(256.4)};
		Vehicle v = chooseAVehicle(vehicles);
		System.out.println(v);
		
		//fun with final
		Car.recommendedMiBtwnOilChanges = 4000; //no good! 
	}
	
	static void vacationTime() {

		System.out.println("let's go to Miami");
		System.out.println("we need a car");
		// using fully qualified classname of Car (package.classname)
		// com.revature.transport.Car c = new com.revature.transport.Car();
		// or we could use imports.... save us typing!!!
		Car c = new Car(2021, "spaceship", "Tesla", 50);
		System.out.println(c);// prints out whatever toString() returns
		System.out.println("do we need to change the oil first?");
		System.out.println("recommended miles between oil changes: " + Car.recommendedMiBtwnOilChanges);
		if (c.getMilesSinceOilChange() >= Car.recommendedMiBtwnOilChanges) {
			System.out.println("stop! change your oil!");
		} else {
			System.out.println("good to go");
		}
		System.out.println("made it to Miami, let's go kayaking");
		Kayak k = new Kayak("red", 4.2, 2, 2);
		// System.out.println(k.getColor());//inherited from superclass
		System.out.println(k);
	}

	static Vehicle chooseAVehicle(Vehicle[] garage) {
		Vehicle chosenVehicle = null;
		// check for steerable vehicles that are not boats, choose first one
		for (int i = 0; i < garage.length; i++) {
			Vehicle v = garage[i];
			if (v instanceof Steerable && !(v instanceof Boat)) {
				chosenVehicle = v;
				return chosenVehicle; // as soon as I find one, return that Vehicle
			}
		}
		return chosenVehicle;
	}

}