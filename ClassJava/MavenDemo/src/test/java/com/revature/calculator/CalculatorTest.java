package com.revature.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator c;	
	
	
	@Before
	public void setCalculator() {
		this.c = new Calculator();
	}
	
	
	
	/*
	 * TDD;
	 * red green refactoring
	 * start with requirement, write test, build code to match
	 * 
	 * Calculator requirements:
	 * (Calculator class
	 * 1) has an add() method which takes a String parameter 
	 * 2. Calling add("") with two comma-separated values returns the sum of those values
	 * 3. calling add*() with null returns zero
	 * 4. Calling add() with > 2 arguments throws CalculatorException
	 * 5. calling add() with incorrect characters (anything but, and Doubles throws CalculatorException
	 * 
	 * 
	 */
	
	@Test
	public void executeAddMethod() throws CalculatorException {
		assertTrue(c.add("") instanceof Double);
	}
	
	@Test
	public void emptyStringReturnsZero() throws CalculatorException {
		assertEquals(0,c.add(""),.001);
	}
	
	@Test
	public void twoNumbersReturnSum() throws CalculatorException{
		assertEquals(28.2,c.add("12.9,15.3"),.001);
	}
	
	@Test
	public void nullReturnsZero() throws CalculatorException{
		assertEquals(0,c.add(null),.001);
	}
	
	@Test
	public void toManyValues() {
		try {
			c.add("1.0, 1.0, 1.0");
			fail("Exception Not Thrown");
			
		} catch (CalculatorException expectedException) {
			
		}
	}
	
	@Test
	public void incorrectValues() {
		try {
			c.add("a, b");
			fail("Exception Not Thrown");
		} catch (CalculatorException expectedException) {
			
		}
		
	}
	
}
