package com.vmware.basictdd;

import java.util.List;
import java.util.OptionalDouble;

public class CalcStats {

	private List<Integer> integers;
    
	public static final String 
        INTEGER_LIST_IS_NULL_MESSAGE = 
           "List of integers cannot be null";

	public static final String 
	      CANNOT_TAKE_AVERAGE_OF_EMPTY_LIST = 
	         "Cannot take average of empty list";
    
	public CalcStats(List<Integer> integers) {
        if (integers == null) 
        	throw new NullPointerException
        	(INTEGER_LIST_IS_NULL_MESSAGE);   
		this.integers = integers;
	}

	public Integer getMinimum() {
        if (integers.size() == 0) return null;
        Integer result = integers.get(0);
        for (Integer i: integers) {
        	if (i != null && i < result) result = i;
        }
        return result;
	}

	public Integer getMaximum() {
		Integer result = integers.get(0);
        for (Integer i: integers) {
        	if (i != null && i > result) result = i;
        }
        return result;
	}

	public Integer getSize() {
		return integers.size();
	}

	public Double getAverage() {
		if (getSize() == 0) throw 
		   new IllegalStateException
		   (CalcStats.CANNOT_TAKE_AVERAGE_OF_EMPTY_LIST);
		Double total = 0.0;
		for (Integer i: integers) {
			if (i != null) total += i;
        }
		return (total/getSize());
	}
}