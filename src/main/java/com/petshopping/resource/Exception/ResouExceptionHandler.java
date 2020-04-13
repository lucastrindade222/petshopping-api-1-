package com.petshopping.resource.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.petshopping.service.Exception.ObejectNotFoudException;

@ControllerAdvice
public class ResouExceptionHandler  {
    @ExceptionHandler(ObejectNotFoudException.class)
	public ResponseEntity<StandarError> objec(ObejectNotFoudException e,HttpServletRequest request){
		
		StandarError err  = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
}
