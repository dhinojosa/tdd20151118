package com.vmware.basictdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Assertions.offset;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalcStatsTest {

	@Test
	public void testMinimumValueWithAListOfOneElement() {
		// How are people going to use this?
		// a. CalcStats.getMinimum(list);
		// b. CalcStats s = new CalcStats(list);
		// s.getMinimum();

		List<Integer> integers = Arrays.asList(3);
		// Subject under test
		CalcStats s = new CalcStats(integers);
		assertEquals(s.getMinimum(), new Integer(3)); // TestNG
	}

	@Test
	public void testEmptyList() {
		List<Integer> integers = new ArrayList<>();
		CalcStats s = new CalcStats(integers);
		assertNull(s.getMinimum());
	}

	@Test
	public void testTwoPositiveTwoNegatives() {
		List<Integer> integers = new ArrayList<>();
		CalcStats s = new CalcStats(integers);
		assertNull(s.getMinimum());
	}

	@Test
	public void testMinimumValueWithTwoElements() {
		List<Integer> integers = Arrays.asList(10, 5);
		CalcStats s = new CalcStats(integers);
		assertEquals(s.getMinimum(), new Integer(5)); // TestNG
	}

	@Test
	public void testMinimumValueWithTwoNegativeElements() {
		List<Integer> integers = Arrays.asList(-7, -3);
		CalcStats s = new CalcStats(integers);
		assertEquals(s.getMinimum(), new Integer(-7)); // TestNG
	}

	@Test
	public void testMinimumValueWithOneNegativeOnePositive() {
		List<Integer> integers = Arrays.asList(-5001, 300);
		CalcStats s = new CalcStats(integers);
		assertEquals(s.getMinimum(), new Integer(-5001)); // TestNG
	}

	@Test
	public void testWithNullsInTheList() {
		// We will be ignoring nulls by majority vote
		List<Integer> integers = Arrays.asList(-5001, null, 300, 1, -20);
		CalcStats s = new CalcStats(integers);
		assertEquals(s.getMinimum(), new Integer(-5001)); // TestNG
	}

	@Test
	public void testWithNullsOnlyNullsInListOf2() {
		// We will be ignoring nulls by majority vote
		List<Integer> integers = Arrays.asList(null, null);
		CalcStats s = new CalcStats(integers);
		assertEquals(s.getMinimum(), null); // TestNG
	}

	@Test
	public void testWith6ElementsWithAMaxValue() {
		// We will be ignoring nulls by majority vote
		List<Integer> integers = Arrays.asList(-40, -20, -300, 1, -22, Integer.MAX_VALUE);
		CalcStats s = new CalcStats(integers);
		assertThat(s.getMinimum()).isEqualTo(-300);
	}

	@Test
	public void testWith6ElementsWithAMinValue() {
		// We will be ignoring nulls by majority vote
		List<Integer> integers = Arrays.asList(-40, 400, Integer.MIN_VALUE, -20, -300, 1, -22);
		CalcStats s = new CalcStats(integers);
		assertThat(s.getMinimum()).isEqualTo(Integer.MIN_VALUE);
	}

	@Test
	public void testWithNullAsList() {
		try {
		    new CalcStats(null);
		    fail("This line should not run");
		} catch (NullPointerException e) {
			assertThat(e).hasMessage
			(CalcStats.INTEGER_LIST_IS_NULL_MESSAGE);
		}
	}
	
	@Test
	public void testWith6ElementsWithADuplicateValue() {
		List<Integer> integers = 
				Arrays.asList
				(-40, -20, -300, -20, -300, 1, -22);
		CalcStats s = new CalcStats(integers);
		assertThat(s.getMinimum()).isEqualTo(-300);
	}
	
    @DataProvider(name="maxData")
    public Object[][] produceMaximumData() {
    	return new Object[][] {
    		{Arrays.asList(5), 5},
    		{Arrays.asList(1,3,5,10,3,9), 10},
    		{Arrays.asList(1,-33,5,12,3,-9), 12},
    		{Arrays.asList(1,-33,null,29,null,-9), 29},
    		{Arrays.asList(null, null), null}
    	};
    }
    
    @Test(dataProvider = "maxData")
    public void testMaximumWithData
        (List<Integer> list, Object expectedResult) {
    	CalcStats s = new CalcStats(list);
		assertThat(s.getMaximum()).
		      isEqualTo(expectedResult);
    }
    
    @DataProvider(name="sizeData")
    public Object[][] produceSizeData() {
    	return new Object[][] {
    		{Arrays.asList(5), 1},
    	    {Arrays.asList(1,3,5,10,3,9), 6},
    		{Arrays.asList(1,-33,5,12,3,-9), 6},
    		{Arrays.asList(1,-33,null,29,null,-9), 6},
    		{Arrays.asList(null, null), 2},
    		{Arrays.asList(), 0}
    	};
    }
    
    @Test(dataProvider = "sizeData")
    public void testSizeWithData
        (List<Integer> list, Integer expectedResult) {
    	CalcStats s = new CalcStats(list);
		assertThat(s.getSize()).
		      isEqualTo(expectedResult);
    }
    
    @DataProvider(name="averageData")
    public Object[][] produceAverageData() {
    	return new Object[][] {
    		{Arrays.asList(5), 5.0},
    	    {Arrays.asList(1,3,5,10,3,9), 5.166},
    		{Arrays.asList(1,-33,5,12,3,-9), -3.5},
    		{Arrays.asList(1,-33,null,29,null,-9), -2.0},
    		{Arrays.asList(null, null), 0.0}
    	};
    }

    @Test(dataProvider = "averageData")
    public void testAverageWithData
        (List<Integer> list, Double expectedResult) {
    	CalcStats s = new CalcStats(list);
		assertThat(s.getAverage()).
		      isEqualTo(expectedResult, offset(.01));
    }
    
    @Test
    public void testAverageWithEmptyList() {
    	CalcStats s = new CalcStats(Arrays.asList());     	
    	try {
    		s.getAverage();
    		fail("This line should not run");
    	} catch (IllegalStateException ise) {
    		assertThat(ise).
    		  hasMessage
    		   (CalcStats.CANNOT_TAKE_AVERAGE_OF_EMPTY_LIST);
    	}	
    }
}












