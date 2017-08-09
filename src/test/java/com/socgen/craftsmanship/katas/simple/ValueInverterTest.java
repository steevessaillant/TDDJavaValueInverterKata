package com.socgen.craftsmanship.katas.simple;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
	public void convertToASCIIShouldReturn_a_WhenPassed97() {
		Assert.assertEquals('a', sut.convertToASCIICharValue(97));
	}
	
	@Test
	public void convertToASCIIShouldReturn_Z_WhenPassed90() {
		Assert.assertEquals('Z', sut.convertToASCIICharValue(90));
	}
	

}
