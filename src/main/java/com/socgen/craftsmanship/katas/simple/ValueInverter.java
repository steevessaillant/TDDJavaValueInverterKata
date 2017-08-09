package com.socgen.craftsmanship.katas.simple;

import org.springframework.stereotype.Component;

@Component
public class ValueInverter {

	public boolean convertValue(boolean value) {
		return !value;
	}

	public long convertValue(Integer value) {
		
		if(value == null)
			throw new NullPointerException("Value was null, cannot pass a null value to this method"); 
		else
			return -value.longValue();
	}

	public char convertToASCIICharValue(int value) {
		//if(value < 32 ||value > 126)
		//	throw new Value 
		return (char)value;
	}

}
