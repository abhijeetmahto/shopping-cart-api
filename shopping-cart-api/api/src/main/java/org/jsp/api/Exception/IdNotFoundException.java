package org.jsp.api.Exception;

public class IdNotFoundException extends RuntimeException{
	public String getMessage() {
		return "Invalid Id";
	}
}
