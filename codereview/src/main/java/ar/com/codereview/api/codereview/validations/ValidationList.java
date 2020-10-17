package ar.com.codereview.api.codereview.validations;

import java.util.Date;
import java.text.DateFormat;
import java.util.List;

import ar.com.codereview.api.codereview.loggers.JobLogger.LoggerEnum;


public class ValidationList {
    
    public boolean todoOk;

    public final int OK = 0;
    
	public final int MESSAGE_LOGMESSAGE = 1;
    
    public final int ERROR_LOGERROR = 2;

	public final int WARNING_LOGWARNING = 3;

    public String estaTodoOk(List<LoggerEnum> resultados, String messageText){
        
        String evaluarEnumerado = "";
        
        for (LoggerEnum x : resultados) {
            if(x.getValue() == MESSAGE_LOGMESSAGE)
                evaluarEnumerado = "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
            else if(x.getValue() == ERROR_LOGERROR) 
                evaluarEnumerado = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
            else if(x.getValue() == WARNING_LOGWARNING)
                evaluarEnumerado = "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
            else
                evaluarEnumerado = "Todo esta bien" + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }
        return evaluarEnumerado;
    }

}
