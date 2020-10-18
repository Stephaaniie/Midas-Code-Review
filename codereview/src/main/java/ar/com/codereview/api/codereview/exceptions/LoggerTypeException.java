package ar.com.codereview.api.codereview.exceptions;

public class LoggerTypeException extends RuntimeException {
    
    public LoggerTypeException(String message) {
        super(message);
    }
	
	public LoggerTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
