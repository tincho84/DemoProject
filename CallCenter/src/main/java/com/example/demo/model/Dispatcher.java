package com.example.demo.model;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Mantiene los empleados disponibles para atender llamadas, 
 * resuelve el llamado, y vuelve el empleado a la cola
 * @author Martin
 *
 */
public class Dispatcher {

	//TODO sacarlos a properties externas
	private static int directorQuantity = 4;
	private static int supervisorQuantity = 3;
	private static int operatorQuantity = 3;
	
	private static PriorityBlockingQueue<Employee> queue = null;
	
	/**
	 * Lo hago de esta forma pero podría estar en el constructur tranquilamente
	 */
	static {
		initDispatcher();
	}
	
	public Dispatcher() {
	}
	
	/**
	 * Crea la cola de empleados en base a la cantidad que tengo disponible de cada uno
	 * La cola tiene una capacidad de 10 empleados, que es la tolerancia de la misma
	 */
	private static void initDispatcher(){
		if (queue == null) {
			queue = new PriorityBlockingQueue<Employee>(10);
			for (int i=0;i<operatorQuantity;i++){
				queue.add(new Operator());
			}
			for (int i=0;i<supervisorQuantity;i++){
				queue.add(new Supervisor());
			}
			for (int i=0;i<directorQuantity;i++){
				queue.add(new Director());
			}
		}		
	}
	
	
	/**
	 * Asigna las llamadas a los empleados disponibles,
	 *  segun el orden de prioridad definido de cada uno
	 */
	public ResultInfo dispatchCall(Call call){
		
		Employee emploee = null;
		try {
			
			emploee = queue.poll(5,TimeUnit.SECONDS);
			
		} catch (InterruptedException e) {
			return new ResultInfo(false, "Error inesperado al obtener un operador",call);
		}
		
		if (emploee==null){
			return new ResultInfo(false, "No hay operadores disponibles",call);
		}
		
		try {
			emploee.attend(call);
		}catch(Exception e) {
			return new ResultInfo(false, "Fallo al procesar el llamado",call);
		}
		
		//termino de atenderlo y lo agrego nuevamente a la cola
		queue.add(emploee);
		
		return new ResultInfo(true,"Exitosa",call);
		
	}
	
}
