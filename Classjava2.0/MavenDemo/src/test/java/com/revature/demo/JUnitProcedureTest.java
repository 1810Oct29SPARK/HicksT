package com.revature.demo;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitProcedureTest {
	
	

	@BeforeClass
	public static void beforeAllTest() {
		System.out.println("in beforeAllTests");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("in beforeTests");
	}
	
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	@Ignore
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
		fail();
	}
	
	@After
	public void afterTest() {
		System.out.println("in afterTests");
	}
	
	@AfterClass
	public static void afterAllTest() {
		System.out.println("in afterAllTests");
	}
}
