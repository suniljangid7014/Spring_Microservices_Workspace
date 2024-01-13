package com.infy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Message> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
		String message = resourceNotFoundException.getMessage();
		Message msg = new Message();
		
		msg.setMessage(message);
		msg.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
		
	}

}
