package com.infy.exception;

import org.springframework.http.HttpStatus;

public class Message {
	
	private String message;
	private HttpStatus status;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	

}
