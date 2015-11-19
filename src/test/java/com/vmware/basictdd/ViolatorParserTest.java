package com.vmware.basictdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.time.LocalDate;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViolatorParserTest {

	private LocalDate todayDate;
	
	@BeforeMethod(groups = {"unit"})
	public void startUp() {
		todayDate = LocalDate.of(2016, 1, 19);
	}
	
	@Test(groups = { "unit"})
	public void parseOnlyName() {
		String data = "Mariyan Tashev";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void parseOnlyNameAndTitleWithNoDate() {
		String data = "Mariyan Tashev~Turkish Gambit";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void parseBestCondition() {
		String data = "Mariyan Tashev~Turkish Gambit~2015-11-09";
		Violator violator = ViolatorParser.parse(data, todayDate);
		assertThat(violator.getName())
		        .isEqualTo("Mariyan Tashev");
		assertThat(violator.getTitle())
		        .isEqualTo("Turkish Gambit");
		assertThat(violator.getCheckoutDate())
		        .isEqualTo(LocalDate.of(2015, 11, 9));
	}
	
	@Test(groups = { "unit" })
	public void testParseEmptyString() {
		String data = "";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testParseStringWithABunchOfSpaces() {
		String data = "                                  ";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testParseFourOrMoreItems() {
		String data = "Mariyan Tashev~Turkish Gambit~2015-11-09~It's a pretty big book";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testEmptyName() {
		String data = "~Turkish Gambit~2015-11-09";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testSpaceName() {
		String data = "      ~Turkish Gambit~2015-11-09";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testEmptyTitleWithoutSpaces() {
		String data = "Mariyan Tashev~~2015-11-09";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testBadDate() {	
		String data = 
				"Mariyan Tashev~Turkish Gambit~2015/11/09";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testBadDateWithTheFuture() {
		String data = 
				"Mariyan Tashev~Turkish Gambit~2018-11-09";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
	@Test(groups = { "unit" })
	public void testEmptyDate() {	
		String data = 
				"Mariyan Tashev~Turkish Gambit~";
		try {
			ViolatorParser.parse(data, todayDate);
			fail("This line should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae)
			.hasMessage(ViolatorParser.INVALID_INPUT);
		}
	}
	
}
