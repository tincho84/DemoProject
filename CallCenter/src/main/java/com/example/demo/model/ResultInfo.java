package com.example.demo.model;

/**
 * Encapsula el resultado luego de atender una llamada
 * @author martin
 *
 */
public class ResultInfo {
	
	private boolean result;
	private String message;
	private Call call;
	
	public ResultInfo(boolean result, String message) {
		this.call = null;
		this.result = result;
		this.message = message;
	}
	
	public ResultInfo(boolean result, String message,Call call) {
		this(result,message);
		this.call = call;
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Call getCall() {
		return call;
	}

	public void setCall(Call call) {
		this.call = call;
	}
		

}
