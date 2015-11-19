package com.vmware.basictdd;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupTest {

	@BeforeClass(groups = {"valid", "invalid"})
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod(groups = {"valid", "invalid"})
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test(groups = {"valid"})
	public void testA() {
		System.out.println("Test A");
	}
	
	@Test(groups = {"valid"})
	public void testB() {
		System.out.println("Test B");
	}
	
	@Test(groups = {"invalid"})
	public void testC() {
		System.out.println("Test C");
	}
	
	@Test(groups = {"invalid"})
	public void testD() {
		System.out.println("Test D");
	}
	
	@Test(groups = {"valid"})
	public void testE() {
		System.out.println("Test E");
	}
	
	@AfterMethod(groups = {"valid", "invalid"})
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass(groups = {"valid", "invalid"})
	public void afterClass() {
		System.out.println("After Class");
	}
}
