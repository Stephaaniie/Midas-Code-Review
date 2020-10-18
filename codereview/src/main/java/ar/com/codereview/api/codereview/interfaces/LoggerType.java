package ar.com.codereview.api.codereview.interfaces;

import java.util.logging.Logger;

public interface LoggerType {

    public static final Logger logger = Logger.getLogger("LoggerType");
        
    public void addMessage(String message);
    public void addWarning(String message);
    public void addError(String message);

    
}
