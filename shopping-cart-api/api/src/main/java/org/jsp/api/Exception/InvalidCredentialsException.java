package org.jsp.api.Exception;

public class InvalidCredentialsException extends RuntimeException{
	public String getMessage() {
		return "Invalid Credentials";
	}
}
