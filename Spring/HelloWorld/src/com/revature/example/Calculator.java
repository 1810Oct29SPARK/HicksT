package com.revature.example;

public class Calculator {
	
	public double add(double arg0, double arg1) {
		
		return arg0 + arg1;
	}
	public double subtract(double arg0, double arg1) {
			
		return arg0 - arg1;
	}
	public double multiply(double arg0, double arg1) {
		
		return arg0*arg1;
	}
	public double divide(double arg0, double arg1) {
		
		return arg0/arg1;
	}
	@Override
	public String toString() {
		return "Calculator []";
	}
	
	
}
