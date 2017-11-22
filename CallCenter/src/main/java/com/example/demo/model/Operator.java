package com.example.demo.model;

public class Operator extends Employee {

	@Override
	public void makeOwnLogic(Call call) {
		System.out.println("Operador - Atendiendo llamada: "+call.getId());
	}

	@Override
	protected int priority() {
		return 1;
	}

}
