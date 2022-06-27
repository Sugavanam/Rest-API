package com.company.sutrix.exceptionController;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.company.sutrix.Exception.UserNotFoundException;
import com.company.sutrix.model.ErrorMessage;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandlingController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class) 
	public final ResponseEntity<ErrorMessage> handlehandleUserNotFoundException(UserNotFoundException ex, WebRequest request)  
	{   
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(),HttpStatus.NOT_FOUND.value(),ex.getClass().getSimpleName(),ex.getMessage()),HttpStatus.NOT_FOUND);  
	} 
	@ExceptionHandler(NoSuchElementException.class) 
	public final ResponseEntity<ErrorMessage> handlehandleNoSuchElementException(NoSuchElementException ex, WebRequest request)  
	{ 
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(),HttpStatus.NOT_FOUND.value(),ex.getClass().getSimpleName(),ex.getMessage()),HttpStatus.NOT_FOUND);  
	} 
	@ExceptionHandler(Exception.class) 
	public final ResponseEntity<ErrorMessage> handlehandleException(Exception ex, WebRequest request)  
	{   
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getClass().getSimpleName(),ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);  
	} 
	@ExceptionHandler(DataIntegrityViolationException.class) 
	public final ResponseEntity<ErrorMessage> handlehandleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request)  
	{   
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getClass().getSimpleName(),ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);  
	} 
}
