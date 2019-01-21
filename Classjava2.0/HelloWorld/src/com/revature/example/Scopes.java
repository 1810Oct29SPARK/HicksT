package com.revature.example;

public class Scopes {

	/*
	 * static variable in the class or "static" scope variable is defined for entire
	 * class
	 * should reference it using Scopes.variable1
	 */
	public static String variable1 = "v1";

	/*
	 * this is a variable that all instances will have in the instance scope not
	 * defined outside of an object of type Scope
	 */
	public String variable2;

	/*
	 * write a constructor with an argument of variable2 the constructor arg has
	 * LOCAL or METHOD scope constructor arg is SHADOWING (same identifier,
	 * different scope) the instance variable of the same name "this" prepended to
	 * the variable name allows us to reference the instance variable instead of the
	 * locally-scoped variable
	 */
	public Scopes(String variable2) {
		this.variable2 = variable2;
	}

	public static void main(String[] args) {

		System.out.println(Scopes.variable1); // variable1 is defined for the whole class
		Scopes s = new Scopes("v2"); // make an instance of v2
		System.out.println(s.variable2); // variable2 is defined for an INSTANCE of the class
		s.myMethod("this is an argument to myMethod");
	}

	// variable3 is declared within a method,
	// therefore!! it is not accessible outside of that method.
	public void myMethod(String variable3) {
		System.out.println(variable3);
		// fun with block scope
		for (int i = 0; i < 10; i++) {
			System.out.println("value of i is: " + i);
		}
		//i is only defined for the for loop! block scope. 
		//System.out.println("value of i is: " + i);
		
		if(variable3.equals("v3")) {
			System.out.println(variable3);
			int j = 17; //j is only defined within this if-block
		} else {
			//j is not defined here! 
		}
	}

}