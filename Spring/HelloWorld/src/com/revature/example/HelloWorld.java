package com.revature.example;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		Calculator calc = new Calculator();
		
		System.out.println(calc.toString());
		
		System.out.println("five plus three is: "+calc.add(5, 3));
		
		String s = "5";
		Double d = Double.parseDouble(s);
		//check type of d, should be parsed as the WRAPPER CLASS Double.
		//not the primitive double (which is why .getClass() works)
		System.out.println(d.getClass());
		
		//fully qualified Class Name : java.lang.Double 
	}

}
