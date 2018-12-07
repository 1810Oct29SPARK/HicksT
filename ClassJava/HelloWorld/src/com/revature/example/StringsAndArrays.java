package com.revature.example;

import java.util.Arrays;

import com.revature.transport.Vehicle;

public class StringsAndArrays {

	public static void main(String[] args) {
		funWithStrings();
		//funWithArrays();
	}
	
	static void funWithArrays() {
		
		/*
		 * Augmented (enhanced) for loops - moving through an Array
		 * or Iterable
		 */
		
		
		String[] arr1 = {"this", "is", "an", "Array"};
		String[] arr2 = new String[4];
		for (int i = 0; i<arr2.length; i++) {
			arr2[i] = "element " + i;
			
		}
		System.out.println("toString from Array: " + arr2.toString());
		System.out.println("toString from Arrays: " + Arrays.toString(arr2));
		
		
		int [][] arr3 = new int[4][3];
		arr3[0][0] = 7;
		arr3[0][2] = 8;
		arr3[3][0] = 9;
		arr3[3][2] = 10;
		
		for(int[] a:arr3) {
			System.out.println(Arrays.toString(a));
		}
		
		Vehicle[] vehicles = new Vehicle[4];
		System.out.println(Arrays.toString(vehicles));
		
	}

	static void funWithStrings() {
		// string literal
		String a = "hello";
		String b = new String("hello");

		/*
		 * .equals() is inherited from Object most reference types override to define
		 * "equality" (usually by the fields) String has it overridden to check the
		 * string literal
		 */
		System.out.println("string a is equal to string b: " + a.equals(b));

		/*
		 * == is good for comparing primitives or checking whether two objects are the
		 * same object (compare the REFERENCE)
		 */
		System.out.println("string a is the same object as string b: " + (a == b));

		// a and b are two different objects pointing to the same literal in the string
		// pool
		
		/*
		 * String API methods
		 * substring
		 * concat
		 * toUpperCase
		 * toLowerCase
		 * replace
		 * indexOf
		 * split
		 * trim
		 * ..and many more
		 */
		
		String test1 = "hello world";
		System.out.println(test1.toUpperCase());
		String test2 = "HeLlO WOrlD";
		System.out.println(test2.toLowerCase());
		System.out.println(test1.substring(3,8));
		System.out.println(test1.concat(test2));
		System.out.println(test1.replace('l', 'p'));
		System.out.println(test1.indexOf('l'));
		System.out.println(test1.indexOf('L')); //no uppercase L!
		String test3 = "the quick brown fox jumped over the lazy dog";
		String[] words = test3.split(" ");
		for (String w : words) {
			System.out.println(w);
		}
	}

}