package sut;

import java.io.*;

import java.lang.*;
import java.util.*;

public class Str_collection {
	ArrayList<String> arr = new ArrayList<String>(); //Array declaration
	
	/*
	 * Input: a single string
	 * Output: return true if added successfully
	 * Otherwise return false
	 * */
	public Boolean add(String input) {
		if (!arr.contains(input)) {
			// string does not yet exist in collection
			arr.add(input);
			return true;
		} else {
			return false;
		}		
	}
	
	/*
	 * Given input string, check if the string is in collection
	 * */
	public Boolean contain(String input) {
		return arr.contains(input);
	}
	
	/*
	 * Get the current length of the array
	 * */
	public int len() {
		return arr.size();
	}
	
	/*
	 * Input: boolean variable if the user wants to replace a string or not
	 * Pick a random string in collection and return it
	 * If array is empty, return nothing
	 * Based on the boolean variable, adjust elements accordingly
	 * */
	public String getRandom(Boolean replacement) {
		
		// A math function to get the random index
		
		if (arr.size() != 0) {
			// Return the element based on generated random index
			int i = (int)(Math.random() * arr.size());
			
			// Store it first
			String chosen = arr.get(i);

			if (!replacement) {

				// We need to remove the chosen element from our array
				arr.remove(i);
			}
			
			return chosen;
		}
		return " ";
		
		
	}
	
	/*
	 * Return a single string that concatenates all the strings in collection
	 * */
	public String print() {
		
		String temp = "";
		for (int i = 0; i < arr.size(); i++) {
			if (i == arr.size() - 1) {
				temp += arr.get(i);
			} else {
				temp += arr.get(i) + " ";
			}
		}
		return temp;
		
	}
	
	/*
	 * Given the element, get its index
	 * */
	public int getIndex(String input) {
		return arr.indexOf(input);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Str_collection obj = new Str_collection(); //Create the object
		Scanner scan_string = new Scanner(System.in); //scanner to deal with input string
		Scanner scan_int = new Scanner(System.in); //Scanner to deal with int value as a signal to continue or stop asking for input string
		boolean replacement; //bool to be passed to getRandom()
		int done; //a signal to stop asking for input string
		
		//Repeatedly ask user to enter string 
		//They can stop anytime
		do {
			System.out.println("Please enter your string: ");
			String input = scan_string.nextLine();
			obj.add(input);
			System.out.println("Enter 1 to continue and 0 to stop if you are done inputting the string into collection");
			
			done = scan_int.nextInt();
			
			
		} while ((done == 1)); 
			
		System.out.println("We will now return a random string from the collection you created, enter 'true' if you do not want replacement of the string. Otherwise, enter 'false' ");
		String before = obj.print();
		replacement = scan_string.nextBoolean();
		String ans = obj.getRandom(replacement);
		System.out.println("The selected string is " + ans);
		String current_collection = obj.print();
		System.out.println("Previous collection of strings is ( " + before + " )");
		System.out.println("Current collection of strings is ( " +  current_collection + " )" );
		System.out.println("Program ended...");
	}

}
