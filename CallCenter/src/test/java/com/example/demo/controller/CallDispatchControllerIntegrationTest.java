package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.MainApplication;
import com.example.demo.model.User;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CallDispatchControllerIntegrationTest {
	
	@LocalServerPort
	private int port;


	@Autowired
	private TestRestTemplate template;


	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
	

	/**
	 * Post con usuario en body
	 */
	@Test
	public void attendCallPostTest() {

		User user = new User("Nombre");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		ResponseEntity<String> response = template.exchange(createURL("/incomeCall"),HttpMethod.POST, entity, String.class);

		assertEquals("Exitosa", response.getBody());

	}

	/**
	 * No admite metodo get, si no le paso el usuario
	 */
	@Test
	public void attendCallGetFailTest() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<User> entity = new HttpEntity<User>(null, headers);

		ResponseEntity<String> response = template.exchange(createURL("/incomeCall"),HttpMethod.GET, entity, String.class);

		assertEquals(405, response.getStatusCode().value());

	}
	
	/**
	 * Post con el usuario por parametro
	 */
	@Test
	public void attendCallPost2Test() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<User> entity = new HttpEntity<User>(null, headers);

		ResponseEntity<String> response = template.exchange(createURL("/incomeCall/Nombre"),HttpMethod.POST, entity, String.class);

		assertEquals("Exitosa", response.getBody());

	}
	
	/**
	 * Get con usuario por parametro
	 */
	@Test
	public void attendCallGetTest() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<User> entity = new HttpEntity<User>(null, headers);

		ResponseEntity<String> response = template.exchange(createURL("/incomeCall/Nombre"),HttpMethod.GET, entity, String.class);

		assertEquals("Exitosa", response.getBody());

	}


}
