package com.revature.example;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.revature.transport.Kayak;

public class GenericsAndReflections {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Car c = new Car(2300, "fury roadster", "mad max", 1000);
		Object[] emptyCars = replicate(c, 3);
		try {	
			((Car) emptyCars[2]).move();
		} catch (MaintenanceException e) {
			e.printStackTrace();
		}
		*/
		funWithReflections();
	}
	
	//
	//fills an array  of specified size with objects of the same type as passed 
	//to the method
	static Object[] replicate(Object O, int size) {
		Object[] replicants = new Object[size];
		for(int i = 0; i < size; i++) {
			replicants[i] = new Object();
		}
		return replicants;
	}
	
	static <T> Object[] replicateWithGenerics(T t, int size) {
		Object[] replicants = new Object[size];
		for(int i = 0; i < size; i++) {
			try {
			replicants[i] = (t.getClass()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return replicants;
	}
	
	/*
	 * time to use the reflection API!
	 * allows us to perform a runtime check on a variable's type
	 * and do so much more
	 * inspect classes at runtime as well
	 * 
	 */

	
	static void funWithReflections() {
		//first thing: get a Class by its fully qualified name
		try {
			Class clazz = Class.forName("com.revature.transport.Kayak");
			System.out.println(clazz.getSimpleName());
			
			//get the fields of Kayak
			Field[] fields = clazz.getDeclaredFields();
			System.out.println(Arrays.toString(fields));
			
			
			//NEw instance of kayak
			Kayak k = (Kayak) clazz.newInstance();
			Field numSeats = clazz.getDeclaredField("numSeats");
			numSeats.setAccessible(true); //accessible with a private class numSeats
			numSeats.set(k, 5);
			System.out.println(k);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
