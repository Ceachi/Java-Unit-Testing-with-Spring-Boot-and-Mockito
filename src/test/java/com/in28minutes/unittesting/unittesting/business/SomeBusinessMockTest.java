package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks // in loc sa faci SomeBusinessImpl business = new SomeBusinessImpl()
	SomeBusinessImpl business;

	@Mock // fara anotare, ar fi similar cu a scrie: SomeDataService dataServiceMock = mock(SomeDataService.class)
	SomeDataService dataServiceMock;

	//@Rule public MockitoRule rule = MockitoJUnit.rule();  // hey folosesc si Junit si Mockito, asta vreau sa spun!
	
	
	@Test
	public void calculateSumUsingDataService_basic() {
		// when( folosesc metoda cutare al obiectului service).thenReturn( trb sa returneze ceva de genu ....)
		// ii zicem noi ce sa returneze
		
		// in metoda calculateSumUsingDataService()
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingDataService());
	}
}
