package ar.com.codereview.api.codereview.resources;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

import ar.com.codereview.api.codereview.config.LoggerConfig;
import ar.com.codereview.api.codereview.exceptions.*;

/**
 * Instancia de la simulacion de una conexion de loggeo con un Archivo.
 */

public class FileManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private LoggerConfig config;
	
	public FileManager(LoggerConfig config) {
		super();
		this.config = config;
	}
	
	public File getLogFile() {
		File logFile = new File(this.config.getProperty("logger.logFilePath"));
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				throw new LogFileException("Error create new log file.", e);
			}
		}
		return logFile;
	}
	
	public FileHandler getFileHandler() {
		try {
			getLogFile();
			return new FileHandler(this.config.getProperty("logger.logFilePath"));
		} catch (SecurityException | IOException e) {
			throw new  NotFoundHandlerException("Error get file handler.", e);
		}
	}

}