package com.vmware.basictdd;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ViolatorParser {

	public static final String INVALID_INPUT = 
			"Invalid violator input";

	public static Violator parse(String data, LocalDate now) {
		String[] items = data.split("~");
		if (items.length != 3)
			throw new IllegalArgumentException(INVALID_INPUT); 
		
		for (String item: items) {
			if ("".equals(item.trim()))
				throw new IllegalArgumentException(INVALID_INPUT);
		}
		
		LocalDate parsedDate = null;
		
	    try {
     		parsedDate = LocalDate.parse(items[2]);
	    } catch (DateTimeParseException dtpe) {
	    	throw new IllegalArgumentException(INVALID_INPUT);
		    
	    }
	    
	    if (parsedDate.isAfter(now)) {
	    	throw new IllegalArgumentException(INVALID_INPUT);
	    }
	    
	    return new Violator(items[0], 
	            items[1], 
	            parsedDate);
	}
}
