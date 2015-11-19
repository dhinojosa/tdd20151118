package com.vmware.basictdd;

import java.time.LocalDate;

public class Violator {

	private String name;
	private String title;
	private LocalDate checkoutDate;
	
	public Violator(String name, String title, 
			LocalDate checkoutDate) {
	     this.name = name;
	     this.title = title;
	     this.checkoutDate = checkoutDate;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
}
