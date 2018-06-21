package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SomeBusinessTest {

	SomeBusinessImpl business;
	
	@Before
	public void setUp() {
		business = new SomeBusinessImpl();
	}
	@Test
	public void calculateSum_basic() {
		//SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);	
	}

	@Test
	public void calculateSum_empty() {
	//	SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { });
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);	
	}

	@Test
	public void calculateSum_oneValue() {
	//	SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 5});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);	
	}
}
