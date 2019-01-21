package com.revature.calculator;

public class Calculator {

	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	public Double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;
//
		if (toAdd == null) {
			return 0.0;
		} 
		if (!toAdd.equals("")) {
			// split the string toADD on a ,delimiter
			String[] numbers = toAdd.split(",");
			// find Decimals in numbers
			if (numbers.length > 2) {
				throw new CalculatorException("Too many values");
			}
			
			int count = 0;
			for (int j = 0; j < numbers.length; j++) {
				for (int i = 0; i < numbers[j].length(); i++) {
					if (numbers[j].charAt(i) == '.') {
						count++;
					}
				}
			}
			if (count != 1) {
				throw new CalculatorException("Data Type not Double");
			} 			
			
			for (String number : numbers) {
				// parse the values as double

				sum += Double.parseDouble(number);
			}
		}
		return sum;
	}
}
