package com.ihg.mss.servlet.exception;

/**
 * Exception class for Portal Call back & Security Service
 * 
 * @author Jay Patel
 *
 */
public class MSSSecurityServiceException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String message = "Portal Security Call-back Service Failed Exception!!!";

	public MSSSecurityServiceException() {
		super(message);
	}

	public MSSSecurityServiceException(String message) {
		super(message);
	}

	public MSSSecurityServiceException(Throwable throwable) {
		super(message, throwable);
	}
	
}
