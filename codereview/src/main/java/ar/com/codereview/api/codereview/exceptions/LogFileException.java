package ar.com.codereview.api.codereview.exceptions;

public class LogFileException extends RuntimeException {
	
	public LogFileException(String message) {
        super(message);
    }
	
	public LogFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
