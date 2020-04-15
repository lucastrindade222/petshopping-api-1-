package com.petshopping.resource.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.petshopping.domain.Exception.StandarError;
import com.petshopping.domain.Exception.StandardError;
import com.petshopping.service.Exception.DataIntegrityException;
import com.petshopping.service.Exception.ObejectNotFoudException;
import com.petshopping.service.Exception.ValidationError;

@ControllerAdvice
public class ResouExceptionHandler  {
    @ExceptionHandler(ObejectNotFoudException.class)
	public ResponseEntity<StandarError> objec(ObejectNotFoudException e,HttpServletRequest request){
		
		StandarError err  = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
    @ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandarError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
    	StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação");
		for(FieldError o : e.getBindingResult().getFieldErrors()) {
			err.addError(o.getField(), o.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
}
