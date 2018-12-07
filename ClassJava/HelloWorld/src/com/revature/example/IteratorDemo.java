package com.revature.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector; 

public class IteratorDemo {

	public static void main(String[] args) {

		ArrayList<Integer> exampleList=new ArrayList<Integer>();
		exampleList.add(6);
		exampleList.add(15);
		exampleList.add(49);
		exampleList.add(61);
		exampleList.add(72);
		exampleList.add(90);
		System.out.println(exampleList);
		
		Iterator<Integer> iterator1 = exampleList.iterator();
		
//		while (iterator1.hasNext()) {
//			//sysout 
//			if(iterator1.next()%2 != 0) {
//				iterator1.remove();
//			}
//		}
		
		System.out.println(exampleList);
		
		Vector<String> v = new Vector<String>(3, 2);
	
		v.addElement("red");
		v.addElement("green");
		v.addElement("blue");
		v.addElement("orange");
		
		Iterator<String> iterator2 = v.iterator();
		
		while(iterator1.hasNext() && iterator2.hasNext()) {
			System.out.println("next value in Arraylist i: " + iterator1.next());
			System.out.println("next value in Vector v: " + iterator2.next());
		}
		
		/*
		 * side note : && vs & , || vs |
		 * doubles are short-circuit operators - secont operand is not checked if...
		 * 
		 * for &&, if first operand is false
		 * for ||, if first operand is true
		 * 
		 * singles are 'bitwise' operators
		 * preference is short-circuit
		 */
	}

}
