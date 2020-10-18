package ar.com.codereview.api.codereview.interfaces;

import java.util.logging.Logger;

/**
 * Se crea esta interface porque tanto File, BD y Console son tipos de Loggeo y
 * responden a la herencia "es un". Y en todas se implementan de forma
 * polimorfica los metodos (addMessage(),addError() y addWarning()).
 */

public interface LoggerType {

    public static final Logger logger = Logger.getLogger("LoggerType");
        
    public void addMessage(String message);
    public void addWarning(String message);
    public void addError(String message);

    
}
