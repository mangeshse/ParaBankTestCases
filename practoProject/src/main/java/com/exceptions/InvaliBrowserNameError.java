package com.exceptions;

public class InvaliBrowserNameError extends Error{

	String msg;

	public InvaliBrowserNameError(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return super.getMessage();
	}

}
