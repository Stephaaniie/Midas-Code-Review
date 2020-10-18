package ar.com.codereview.api.codereview.resources;

import java.io.Serializable;
import java.util.logging.ConsoleHandler;

import ar.com.codereview.api.codereview.config.DefaultConfiguration;
import ar.com.codereview.api.codereview.config.LoggerConfig;

public class ConsoleManager implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static ConsoleManager instance = null;
	
	private ConsoleManager(LoggerConfig configuration) {
		super();
	}
	
	public static synchronized ConsoleManager getInstance(DefaultConfiguration defaultConfiguration) {
		if (instance == null) {
			instance = new ConsoleManager(defaultConfiguration);
		}
		return instance;
	}
	
	public ConsoleHandler getConsoleHandler() {
		return new ConsoleHandler();
	}
}
