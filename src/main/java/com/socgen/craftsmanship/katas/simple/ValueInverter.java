package com.socgen.craftsmanship.katas.simple;

import java.awt.Color;

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
		if(value < 33 || value > 126)
			throw new IllegalArgumentException("Value parameter is out of the 33 - 126 Range."); 
		
		return (char)value;
	}

	public Color convertHexToColor(String hexValue) {
		return Color.decode(hexValue);
	}
	


}
