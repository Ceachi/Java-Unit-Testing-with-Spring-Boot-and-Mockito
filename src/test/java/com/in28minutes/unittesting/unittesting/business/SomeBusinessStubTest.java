package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

/*
 * 
 * Destul de dificil, putem crea clase Stub foarte multe,
 * daca dai update la interfata SomeDataService si ai mai adauga o metoda in ea,
 * toate stuburile ar da eroare de compilare, incercam si cu mokuri
 */
class SomeDataServiceStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { };
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());//new int[] {1,2,3}
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();//new int[] {}
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();//new int[] { 5 }
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
