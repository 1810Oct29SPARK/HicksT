package assignments.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Mutations {

	public static void main(String[] args) {
		String mutStart;
		String mutEnd;
		String[] mutBank;
		Scanner sc3 = new Scanner(System.in);
		mutStart = getStart();
		mutEnd = getEnd();
		System.out.println("Bank Size? : ");
		int bankSize = sc3.nextInt();
		mutBank = getBankValues(bankSize);
		getCalculation(mutStart, mutEnd, mutBank, bankSize);

	}

	public static int getCalculation(String mutStart, String mutEnd, String[] mutBank, int bankSize) {

		int counter = 0;
		int matches = 0;
		int interval = 0;
		int total = 0;
		int temp = 0;

		char[] chrStart = mutStart.toCharArray();
		char[] chrEnd = mutEnd.toCharArray();

		for (int i = 0; i < chrStart.length; i++) {
			for (int j = 0; j < mutBank.length; j++) {
				for (int k = 0; k < mutBank[j].length(); k++) {
					interval++;
					if (chrStart[i] == mutBank[j].charAt(k) && interval < 8) {
						matches++;
					}
					if (chrEnd[i] == mutBank[j].charAt(k) && interval == 8) {
						matches++;

						if (matches == 8) {
							break;
						}
					}

					temp = matches;
					matches = 0;
				}
				System.out.println(temp);
			}
			counter++;
		}

		System.out.println("Correct Mutations : " + counter);
		return counter;
	}

	public static String[] getBankValues(int x) {
		;
		String[] values = new String[x];
		Scanner sc4 = new Scanner(System.in);
		for (int i = 0; i < x; i++) {
			System.out.println("Input Value " + i + ": ");

			values[i] = sc4.nextLine();
			values[i] = values[i].toUpperCase();
			values[i] = values[i].replaceAll("[^A-Z]", "");
			values[i] = values[i].replaceAll("[^AGCT]", "");

			if (values[i].length() < 8) {
				System.out.println("Invalid Input: Try Again!");
				System.out.println("Input Value " + i + ": ");
				values[i] = sc4.nextLine();
			}

		}

		return values;

	}

	public static String getStart() {

		System.out.println("Input mutation Start: ");
		Scanner sc = new Scanner(System.in);
		String start = sc.nextLine();
		start = start.toUpperCase();
		start = start.toUpperCase();
		start = start.replaceAll("[^AGCT]", "");
		if (start.length() < 8) {
			System.out.println("Invalid Input: Try Again!");
			System.out.println("Input mutation Start: ");
			start = sc.nextLine();
		}
		return start;
	}

	public static String getEnd() {

		System.out.println("Input mutation End: ");
		Scanner sc2 = new Scanner(System.in);
		String end = sc2.nextLine();
		end = end.toUpperCase();
		end = end.replaceAll("[^AGCT]", "");
		if (end.length() < 8) {
			System.out.println("Invalid Input: Try Again!");
			System.out.println("Input mutation End: ");
			end = sc2.nextLine();
		}
		return end;
	}

}
