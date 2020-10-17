package ar.com.codereview.api.codereview.validations;

import ar.com.codereview.api.codereview.loggers.JobLogger.LoggerEnum;

public class Validation {

    public LoggerEnum validacionError(boolean error, boolean logError){
        if(error && logError)
            return LoggerEnum.ERROR;
        return LoggerEnum.OK;
    }
    
    public LoggerEnum validacionMenssage(boolean message,boolean logMessage) {
        if(message && logMessage)
            return LoggerEnum.MESSAGE;
        return LoggerEnum.OK;
    }

    public LoggerEnum validacionWarning(boolean warnining, boolean warningError) {
        if(warnining && warningError)
            return LoggerEnum.WARNING;
        return LoggerEnum.OK;
    }
}
