package com.example.demo.model;

import java.util.Date;

/**
 * Clase abstracta padre de todos los posibles empleados que puedan resolver una llamada
 * @author martin
 *
 */
public abstract class Employee implements Comparable<Employee>{

	
	/**
	 * Metodo encargado de resolver una llamada, posee el proceso comun de cualquier 
	 * tipo de Employee que podria resolver una llamada
	 * @param call
	 */
	public void attend(Call call) {
		
		makeOwnLogic(call);
		int time = RandomTime.getRandomTime();
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		call.finishCall(new Date());
	
	}
	
	/**
	 * Cada tipo de empleado deberia realizar la logica propia
	 * en el caso que sea necesario
	 */
	protected abstract void makeOwnLogic(Call call);
	
	@Override
	public int compareTo(Employee o) {
		
		if (this.priority()>o.priority())
			return 1;
		return 0;
	}

	protected abstract int priority();

	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
}
