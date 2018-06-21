package com.in28minutes.unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class) // to launch a Spring Unit test
@WebMvcTest(HelloWorldController.class) // spunem ca este un test MVC si vrem sa testam urm Controller
public class HelloWorldControllerTest {
	
	@Autowired // punem un mockMVC (un bean cu ajutorul caruia putem executa requesturi)s
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		//call GET "/hello-world"  application/json
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request) // asta poate arunca o exceptie
				.andExpect(status().isOk()) // asteptam ca statusul sa fie 200 Ok
				.andExpect(content().string("Hello World"))
				.andReturn();
	
		//verify "Hello World"
		// nu am nevoie neaparat de assertEquals, pt ca e prea simplu si il facem mai sus, daca
		// daca devine mai complex, facem aserturi
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
