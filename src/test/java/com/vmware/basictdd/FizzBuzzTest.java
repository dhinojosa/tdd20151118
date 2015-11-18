package com.vmware.basictdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class FizzBuzzTest {
    
	@Test
	public void testOne() {
		//What is the simplest?
		//a. do you want to call a method that given number it returns a string?
		//b. do you want instantiate something
		//c. do you even need state?
		
		//a.
		assertThat(FizzBuzz.getStringValue(1)).isEqualTo("1");
		
		//b.
        //List<Integer> list = Arrays.asList(1,2,3,4);
        //FizzBuzz fb = new FizzBuzz(list);
        //assertThat(fb.getResult(0)).isEqual("1");
	}	
	
	
	@Test
	public void testThree() {
		assertThat(FizzBuzz.getStringValue(3)).isEqualTo("Fizz");
	}
	
	@Test
	public void testSix() {
		assertThat(FizzBuzz.getStringValue(6)).isEqualTo("Fizz");
	}
	
	@Test
	public void testFive() {
		assertThat(FizzBuzz.getStringValue(5)).isEqualTo("Buzz");
	}
	
	@Test
	public void testTen() {
		assertThat(FizzBuzz.getStringValue(10)).isEqualTo("Buzz");
	}
	
	@Test
	public void testFifteen() {
		assertThat(FizzBuzz.getStringValue(15)).isEqualTo("FizzBuzz");
	}
	
	@Test
	public void testFourtyFive() {
		assertThat(FizzBuzz.getStringValue(45)).isEqualTo("FizzBuzz");
	}
	
	//TDD: Atomic, Consistent, Isolated
    //This is probably too large of a test break it down.
	//  @Test
	//	public void testRun() {
    //		assertThat(FizzBuzz.run()).
    //		    isEqualTo(
    //		     Arrays.asList(1, 2, "Fizz", 4, "Buzz"));
    //	}
}
