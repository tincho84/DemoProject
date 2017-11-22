package com.example.demo.model;

import java.util.Random;

/**
 * Devuelve un tiempo random entre 5 y 10,que es el tiempo que puede durar una llamada
 * @author martin
 *
 */
public class RandomTime {

	
	public static int getRandomTime() {
		Random rand = new Random(); 
		return rand.nextInt((10 - 5) + 1) + 5;
	}
}
