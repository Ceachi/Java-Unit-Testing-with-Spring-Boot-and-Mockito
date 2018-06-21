package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10, \"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
		// daca strict = true, verifica ca totul sa fie exact asa ca acolo
		// daca strict = false, nu trb neaparat sa verific toti parametrii, chiar as putea avea space in string
	}

	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		// in cazul in care ai spatiu sa zicem ball 2 trb sa pui \
		String expectedResponse = "{id:1, name:Ball, price:10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
}
