package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	// return multiple values at the same time
	@Test
	public void returnDifferentValues() {
		// prima data cand apelezi sa returneze 5
		// a doua oara sa returneze 10
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	@Ignore
	public void returnWithParameters() {
		// asteapta ceva doar la 0, dar pentru altele imi da defaul value(null)
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");

		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}

	@Test
	public void verificationBasics() {
		// SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		// Verify ( pt scenarii in care valuarea nu este returnata)
		verify(mock).get(0); // vreau sa verifica ca metoda get(0) este apelata pe mock, pe test
		verify(mock, times(2)).get(anyInt());// verifica ca a fost apelat get() a lui mock de 2 ori indiferent de parametrii dati
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void argumentCapturing() {
		
		//SUT
		mock.add("SomeString");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture()); // vreau sa aflu care este acel argument dat,iar acela in cazul asta este un String
		
		assertEquals("SomeString", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
		
	}

	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	// spy = foloseste clasa reala, mock nu foloseste clasa reala
	/*
	 * De ce sa folosesti spy? daca vrei sa folosesti dependenta originala
	 */
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class); // in loc de mock am spy
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);// ce a fost anterior se pierde si de acum size o sa fie mereu 5
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
	}

	
}
