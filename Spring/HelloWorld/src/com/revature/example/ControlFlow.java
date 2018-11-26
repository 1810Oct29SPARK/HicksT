package com.revature.example;

import org.omg.Messaging.SyncScopeHelper;

public class ControlFlow {

	public static void main(String[] args) {

		// ifStatements(7.5, 4);
		// forLoops();
		//whileLoops();
		switchCases();
		
	}

	static void ifStatements(double a, double b) {

		// Can have as many else-if's as you want
		if (a > b) {
			System.out.println("a is greater than b");
		} else if (a == b) {
			System.out.println("a equals b");
		} else {
			System.out.println("a is less than b");
		}

	}

	static void forLoops() {

		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		/*
		 * for(;;) {
		 * 
		 * }
		 */
		/*
		 * break and continue "break" = exit the structure (terminates for, while, or
		 * do-while) "continue" = goes to next iteration
		 */

		System.out.println("Even numbers");
		for (int j = 0;; j++) {
			if (j % 2 != 0) {
				continue;
			}
			System.out.println(j);
			if (j == 20) {
				break;
			}
		}
	}

	static void whileLoops() {
		// this is infinite! using a break statement to make it not infinite
		int i = 0;
		while (true) {
			System.out.println(i);
			i += 1;
			if (i < 150) {
				break;
			}
		}

		do {
			System.out.println("do block always runs before condition is checked");
		} while (false);
	}

	static void switchCases() {
		/*
		 * switch statements allows us to execute different behavior based on an
		 * expression an be byte, short, int, Enum, String, Wrapper class;
		 */

		String dayOfWeek = "Tuesday";
		switch (dayOfWeek) {
		case "Sunday":
			System.out.println("today is Sunday");
		case "Monday":
			System.out.println("today is Monday");
		case "Tuesday":
			System.out.println("today is Tuesday");
		case "Wednesday":
			System.out.println("today is Wednesday");
		case "Thursday":
			System.out.println("today is Thursday");
		case "Friday":
			System.out.println("today is Friday");
		case "Saturday":
			System.out.println("today is Saturday");
		}

	}

}
