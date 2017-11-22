package com.example.demo.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomTimeTest {

	@Test
	public void prioritySupervisorTest() throws Exception {
		int valor1 = RandomTime.getRandomTime();
		assertTrue(valor1 >= 5 && valor1 <= 10);
		int valor2 = RandomTime.getRandomTime();
		assertTrue(valor2 >= 5 && valor2 <= 10);
		int valor3 = RandomTime.getRandomTime();
		assertTrue(valor3 >= 5 && valor3 <= 10);
		int valor4 = RandomTime.getRandomTime();
		assertTrue(valor4 >= 5 && valor4 <= 10);
		int valor5 = RandomTime.getRandomTime();
		assertTrue(valor5 >= 5 && valor5 <= 10);
		int valor6 = RandomTime.getRandomTime();
		assertTrue(valor6 >= 5 && valor6 <= 10);
		int valor7 = RandomTime.getRandomTime();
		assertTrue(valor7 >= 5 && valor7 <= 10);
		int valor8 = RandomTime.getRandomTime();
		assertTrue(valor8 >= 5 && valor8 <= 10);
		int valor9 = RandomTime.getRandomTime();
		assertTrue(valor9 >= 5 && valor9 <= 10);
		int valor10 = RandomTime.getRandomTime();
		assertTrue(valor10 >= 5 && valor10 <= 10);
	}

}
