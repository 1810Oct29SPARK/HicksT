;package com.revature.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.comparisons.CarMakeCompare;
import com.revature.transport.Car;

public class Comparisons {

	public static void main(String[] args) {
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car(2021, "Spaceship", "Tesla", 50));
		carList.add(new Car(2007, "LessFancy", "Cadillac", 50));
		carList.add(new Car(1997, "Fiesty", "Ford", 500));
		carList.add(new Car(2007, "Fancy", "Cadillac", 50));

		System.out.println(carList.get(0).compareTo(carList.get(1)));
		System.out.println("Cars before soet: ");
		for (Car c : carList) {
			System.out.println(c);

		}

		sortWithComparable(carList);
		sortWithComparator(carList, new CarMakeCompare());
	}

	static void sortWithComparable(List<Car> carList) {

		Collections.sort(carList);

		System.out.println("Cars after soet: ");
		for (Car c : carList) {
			System.out.println(c);

		}
	}
	
	static void sortWithComparator(List<Car> carList, Comparator<Car> c) {
		Collections.sort(carList, c);
		System.out.println("Cars after sort with " + c.getClass()+ ":");
		for (Car car : carList) {
			System.out.println(car);
		}
	}
}

