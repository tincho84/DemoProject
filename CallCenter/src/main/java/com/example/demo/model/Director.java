package com.example.demo.model;

public class Director extends Employee {

	@Override
	public void makeOwnLogic(Call call) {
		System.out.println("Director - Atendiendo llamada: "+call.getId());
	}

	@Override
	protected int priority() {
		return 3;
	}

}
