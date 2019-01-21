package com.revature.comparisons;

import java.util.Comparator;

import com.revature.transport.Car;

public class CarMakeCompare implements Comparator<Car> {

	@Override
	public int compare(Car arg0, Car arg1) {
		// TODO Auto-generated method stub
		return arg0.getMake().compareTo(arg1.getMake());
	}
	
}
