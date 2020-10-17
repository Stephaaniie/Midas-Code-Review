package ar.com.codereview.api.codereview.loggers;

import java.util.Map;
import java.util.logging.Logger;

public class JobLogger {
	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;
	private boolean initialized;
	private static Map dbParams;
	private static Logger logger;

	public JobLogger(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
			boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {
		logger = Logger.getLogger("MyLog");  
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = dbParamsMap;
    }

    public static boolean isLogToFile() {
        return logToFile;
    }

    public static void setLogToFile(boolean logToFile) {
        JobLogger.logToFile = logToFile;
    }

    public static boolean isLogToConsole() {
        return logToConsole;
    }

    public static void setLogToConsole(boolean logToConsole) {
        JobLogger.logToConsole = logToConsole;
    }

    public static boolean isLogMessage() {
        return logMessage;
    }

    public static void setLogMessage(boolean logMessage) {
        JobLogger.logMessage = logMessage;
    }

    public static boolean isLogWarning() {
        return logWarning;
    }

    public static void setLogWarning(boolean logWarning) {
        JobLogger.logWarning = logWarning;
    }

    public static boolean isLogError() {
        return logError;
    }

    public static void setLogError(boolean logError) {
        JobLogger.logError = logError;
    }

    public static boolean isLogToDatabase() {
        return logToDatabase;
    }

    public static void setLogToDatabase(boolean logToDatabase) {
        JobLogger.logToDatabase = logToDatabase;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public static Map getDbParams() {
        return dbParams;
    }

    public static void setDbParams(Map dbParams) {
        JobLogger.dbParams = dbParams;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        JobLogger.logger = logger;
    }

    public enum LoggerEnum {
        OK(0),
        MESSAGE(1),
        ERROR(2),
        WARNING(3);

        private final int value;

        private LoggerEnum(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
        
        public static LoggerEnum parse(int id) {

            LoggerEnum status = null;
            
            for(LoggerEnum item : LoggerEnum.values()) {
                if(item.getValue() == id) {
                    status = item;
                }
            }
            return status;
        }
    } 

}