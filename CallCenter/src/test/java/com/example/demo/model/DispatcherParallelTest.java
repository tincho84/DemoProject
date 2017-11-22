package com.example.demo.model;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DispatcherParallelTest {


	private static Dispatcher dis;

	@BeforeClass
	public static void init(){
		dis = new Dispatcher();
	}

	@AfterClass
	public static void clear(){
		Dispatcher.resetQueue();
	}
	
	@Test
	public void attend1CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-1",new User("Usuario-1")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend2CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-2",new User("Usuario-2")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend3CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-3",new User("Usuario-3")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend4CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-4",new User("Usuario-4")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend5CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-5",new User("Usuario-5")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend6CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-6",new User("Usuario-6")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend7CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-7",new User("Usuario-7")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend8CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-8",new User("Usuario-8")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend9CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-9",new User("Usuario-9")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

	@Test
	public void attend10CallTest() throws Exception {
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric-10",new User("Usuario-10")));
		assertThat(ri.isResult(), equalTo(true));
		assertEquals(ri.getMessage(), "Exitosa");
	}

}
