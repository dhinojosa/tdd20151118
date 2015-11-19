package com.vmware.basictdd;

import java.util.List;

public class FizzBuzz {

	private FizzBuzz() {}
	
	public static void main(String[] args) {
	    for (int i = 0; i < 100; i++) {
	    	System.out.println(FizzBuzz.getStringValue(i));
	    }
	}

	public static String getStringValue(int i) {
		if (i % 15 == 0) return "FizzBuzz"; //the tough one
		if (i % 3 == 0) return "Fizz";
		if (i % 5 == 0) return "Buzz";
		return Integer.toString(i);
	}


}
