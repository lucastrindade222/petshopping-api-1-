package com.petshopping.service.Exception;

public class ObejectNotFoudException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
 public ObejectNotFoudException(String msg) {
	 super(msg);
 }
 
	
public ObejectNotFoudException(String msg,Throwable cause) {
	 super(msg,cause);
}
 

}
