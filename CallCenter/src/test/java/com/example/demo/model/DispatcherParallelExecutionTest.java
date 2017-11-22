package com.example.demo.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;


/**
 * Ejecución de 10 en paralelo, utilizando todos los test de la clase DispatcherParallelTest,
 * ejecutados en el mismo momento.
 * @author Martin
 *
 */
public class DispatcherParallelExecutionTest {


	
	@Test
	public void runAllTest(){
	    
	    Class[] testClasses={DispatcherParallelTest.class};

	    //Parallel execute only methods in classes
	    org.junit.runner.Result result = JUnitCore.runClasses(ParallelComputer.methods(), testClasses);

	    //Run Parallel all methods in all test classes which declare in testClasses[]
	    //method accept new ParallelComputer(classes, methods)
	    List<Failure> failures = result.getFailures();


	    if(result.wasSuccessful() != true){
	    	for(int i = 0; i < failures.size(); i++){
	            System.out.println("<---------------New test method--------------->");
	            System.out.println(failures.get(i).toString());
	        }
	        assertTrue(false);
	    }else {
	        assertTrue(true);
	        }
	    }
	

}
