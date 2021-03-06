package com.example.demo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class DispatcherTest {


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
	public void dispatchCallTest() throws Exception {
		
		ResultInfo ri = dis.dispatchCall(new Call("idgeneric",new User("Usuario1")));

		assertEquals(ri.getMessage(), "Exitosa");
		assertEquals(ri.isResult(), true);
		
		Call call = ri.getCall();
		
		assertEquals(call.getUser().getName(), "Usuario1");
		
	}
	

	@Test
	public void dispatchCallFailTest() throws Exception {
		
		ResultInfo ri = dis.dispatchCall(null);
		assertEquals(ri.getMessage(), "Fallo al procesar el llamado");
		assertEquals(ri.isResult(), false);
		Call call = ri.getCall();
		assertNull(call);
		
	}
	
	/**
	 * Ejecución de 10 llamadas
	 */
	@Test
	public void dispatch10CallTest() throws Exception {
		
		for (int i=0;i<10;i++) {
			ResultInfo ri = dis.dispatchCall(new Call("idgeneric"+i,new User("Usuario-"+i)));
		
			assertEquals(ri.getMessage(), "Exitosa");
			assertEquals(ri.isResult(), true);
			
			Call call = ri.getCall();
			
			assertEquals(call.getUser().getName(), "Usuario-"+i);
		
		}
	}

	
}
