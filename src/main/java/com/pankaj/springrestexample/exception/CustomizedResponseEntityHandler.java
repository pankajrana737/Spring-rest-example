package com.pankaj.springrestexample.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
// applicable to all controller
@ControllerAdvice
/// bacause it return response so used @restcontroller
@RestController
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final  ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
	ExceptionResponse exceptionResponse= 
			new ExceptionResponse(new Date(),ex.getLocalizedMessage(),request.getDescription(false));
			
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final  ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		
	ExceptionResponse exceptionResponse= 
			new ExceptionResponse(new Date(),ex.getLocalizedMessage(),request.getDescription(false));
			
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


		ExceptionResponse exceptionResponse= 
				new ExceptionResponse(new Date(),"Validation is falied",ex.getBindingResult().toString());
				
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
