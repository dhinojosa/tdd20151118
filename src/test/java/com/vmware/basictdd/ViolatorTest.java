package com.vmware.basictdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.testng.annotations.Test;


//java.time.LocalDate

public class ViolatorTest {

	@Test(groups={"unit"})
	public void testViolatorCreation() {
		String name = "Alexander Kanchev";
		String title = "Steve Jobs Autobiography";
		LocalDate localDate = LocalDate.of(2013, 11, 20);
		Violator violator = 
				new Violator(name, title, localDate);
        assertThat(violator.getName()).isEqualTo(name);
        assertThat(violator.getTitle()).isEqualTo(title);
        assertThat(violator.getCheckoutDate()).isEqualTo(localDate);
	}
}
