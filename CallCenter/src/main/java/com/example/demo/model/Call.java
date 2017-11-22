package com.example.demo.model;

import java.util.Date;

/**
 * Representa la llamada con los datos de la misma
 * @author martin
 *
 */
public class Call {

	
	//tiempo en el que inicio la llamada
	private Date initTime;

	//tiempo en el que termino la llamada
	private Date finishTime;

	private String id;
	
	private boolean finished = false;
	
	private User user; 
	
	public Call(String id,User user) {
		this.initTime = new Date();
		this.id = id;
		this.user = user;
	}

	public void finishCall(Date date){
		finished = true;
		finishTime = date;
	}

	public String getId() {
		return id;
	}
	
	public boolean isFinished() {
		return finished;
	}

	public Date getInitTime() {
		return initTime;
	}

	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Date getFinishTime() {
		return finishTime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
}
