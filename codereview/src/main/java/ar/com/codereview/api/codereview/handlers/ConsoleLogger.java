package ar.com.codereview.api.codereview.handlers;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;

import ar.com.codereview.api.codereview.config.DefaultConfiguration;
import ar.com.codereview.api.codereview.config.LoggerConfig;
import ar.com.codereview.api.codereview.exceptions.MessageException;
import ar.com.codereview.api.codereview.interfaces.LoggerType;
import ar.com.codereview.api.codereview.resources.ConsoleManager;


public class ConsoleLogger implements LoggerType {
	
	private ConsoleManager manager;
	
	public ConsoleLogger(DefaultConfiguration defaultConfiguration) {
		this.manager = ConsoleManager.getInstance(defaultConfiguration);
		logger.addHandler(this.manager.getConsoleHandler());
	}
	
	public ConsoleLogger(LoggerConfig configuration) {
	}

	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		logger.log(Level.INFO, message);
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
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