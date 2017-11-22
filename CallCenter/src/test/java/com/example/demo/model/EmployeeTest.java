package com.example.demo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {

	
	@Test
	public void priorityDirectorTest() throws Exception {
		Employee director = new Director();
		assertEquals(director.priority(), 3);
	}
	
	@Test
	public void prioritySupervisorTest() throws Exception {
		Employee director = new Supervisor();
		assertEquals(director.priority(), 2);
	}
	
	@Test
	public void priorityOperatorTest() throws Exception {
		Employee director = new Operator();
		assertEquals(director.priority(), 1);
	}
	
}
