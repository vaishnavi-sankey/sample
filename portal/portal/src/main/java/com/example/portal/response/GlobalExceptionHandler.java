package com.example.portal.response;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request){
		ErrorHandler errorHandler = 
				new ErrorHandler(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorHandler, HttpStatus.NOT_FOUND);
	}

	// handling global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorHandler errorHandler = 
				new ErrorHandler(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorHandler, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}