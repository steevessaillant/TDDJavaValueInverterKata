package com.socgen.craftsmanship.katas.simple;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.awt.Color;

public class ValueInverterTest extends TestBase {

	@Autowired
	private ValueInverter sut;

	@Test
	public void convertValueShouldReturnFalseWhenPassedTrue() {
		Assert.assertEquals(false, sut.convertValue(true));
	}

	@Test
	public void convertValueShouldReturnTrueWhenPassedFalse() {
		Assert.assertEquals(true, sut.convertValue(false));
	}

	@Test
	public void convertValueShouldThrowNullPointerExceptionWhenPassedNullAndDisplayMessage() {
		catchException(sut).convertValue(null);
		assert caughtException() instanceof NullPointerException;
		caughtException().getMessage().contains("Value was null, cannot pass a null value to this method");
	}

	@Test
	public void convertValueShouldReturnMinusOneWhenPassedOne() {
		Assert.assertEquals(-1, sut.convertValue(1));
	}

	@Test
	public void convertValueShouldReturnOneWhenPassedMinusOne() {
		Assert.assertEquals(1, sut.convertValue(-1));
	}

	@Test
	public void convertValueShouldThrowIllegalArgumentExceptionWhenPassedAValueIsLowerThan34() {
		catchException(sut).convertToASCIICharValue(32);
		assert caughtException() instanceof IllegalArgumentException;
		caughtException().getMessage().contains("Value parameter is out of the 33 - 126 Range.");
	}
	
	@Test
	public void convertValueShouldThrowIllegalArgumentExceptionWhenPassedAValueIsHigherThan126() {
		catchException(sut).convertToASCIICharValue(127);
		assert caughtException() instanceof IllegalArgumentException;
		caughtException().getMessage().contains("Value parameter is out of the 33 - 126 Range.");
	}
	
	@Test
	public void convertToASCIIShouldReturn_ExclamationPoint_WhenPassed33() {
		Assert.assertEquals('!', sut.convertToASCIICharValue(33));
	}
	
	@Test
	public void convertToASCIIShouldReturn_a_WhenPassed97() {
		Assert.assertEquals('a', sut.convertToASCIICharValue(97));
	}
	
	@Test
	public void convertToASCIIShouldReturn_Z_WhenPassed90() {
		Assert.assertEquals('Z', sut.convertToASCIICharValue(90));
	}
	
	@Test
	public void convertToASCIIShouldReturn_Tilde_WhenPassed126() {
		Assert.assertEquals('~', sut.convertToASCIICharValue(126));
	}
	
	@Test
	public void convertHexToColorShouldReturnWhiteWhenPassedFFFFFF(){
		Assert.assertEquals(Color.WHITE, sut.convertHexToColor("#FFFFFF"));
	}
	
	@Test
	public void convertHexToColorShouldReturnWhiteWhenPassed000000(){
		Assert.assertEquals(Color.BLACK, sut.convertHexToColor("#000000"));
	}
}
