package ar.com.codereview.api.codereview.handlers;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;

public class FileLogger {
    
    private static Map dbParams;

    /*
     * Ejecucion del logueo con archivos el mismo realiza la apertura y 
     * se cierra luego de ser utilizado, para evitar conflictos.
    */

    public static FileHandler getFileHandler(Map dbParamsMap) throws IOException {
        try {
	    	dbParams = dbParamsMap;
	        File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
	        if (!logFile.exists()) {
	            logFile.createNewFile();
	        }
	        FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
	        return fh;
        } catch (IOException e){
        	e.printStackTrace();
        	throw e;
        }
    }
}
