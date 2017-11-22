package com.example.demo.model;

public class Supervisor extends Employee {

	@Override
	public void makeOwnLogic(Call call) {
		System.out.println("Supervisor - Atendiendo llamada: "+call.getId());
	}

	@Override
	protected int priority() {
		return 2;
	}

}
