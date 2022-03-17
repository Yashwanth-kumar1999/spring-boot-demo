package com.lti.exception;

public class CustomerServiceException extends RuntimeException{
public CustomerServiceException(String msg) {
	super(msg);
}
}