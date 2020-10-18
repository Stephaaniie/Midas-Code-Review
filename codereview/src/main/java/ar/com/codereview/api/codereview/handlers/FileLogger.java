package ar.com.codereview.api.codereview.handlers;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;
import ar.com.codereview.api.codereview.config.LoggerConfig;
import ar.com.codereview.api.codereview.exceptions.MessageException;
import ar.com.codereview.api.codereview.interfaces.LoggerType;
import ar.com.codereview.api.codereview.resources.FileManager;

/**
 * Clase que implemta la interface LoggerType y ademas tiene como atributo un
 * File manager, en el mismo se puede agregar mensajes, warning y error. Y
 * tiene dos tipos de constructor: uno por default y otro cuando la instancia no
 * es nula y recibira la configuracion para ser instanciada.
 */

public class FileLogger implements LoggerType {
	
	private FileManager manager;
	
	public FileLogger(LoggerConfig configuration) {
		this.manager = new FileManager(configuration);
		logger.addHandler(this.manager.getFileHandler());
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		logger.log(Level.INFO, message);
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
		}
		logger.log(Level.WARNING, message);
	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}
		logger.log(Level.SEVERE, message);
	}

}