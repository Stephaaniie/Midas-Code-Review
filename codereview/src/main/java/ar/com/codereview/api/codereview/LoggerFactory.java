package ar.com.codereview.api.codereview;

import ar.com.codereview.api.codereview.handlers.*;
import ar.com.codereview.api.codereview.config.*;
import ar.com.codereview.api.codereview.exceptions.LoggerTypeException;
import ar.com.codereview.api.codereview.interfaces.LoggerType;

public class LoggerFactory {
	
	public static final String FILE_LOGGER  = "File";

	public static final String BD_LOGGER  = "BaseDato";

	public static final String CONSOLE_LOGGER  = "Console";

	private LoggerFactory() {
		super();
	}
	
	public static LoggerType getLogger(String type) {

		LoggerType tipoLogger = null;

		switch (type) {
			case FILE_LOGGER:
				tipoLogger = new FileLogger(new DefaultConfiguration());
				break;
			case CONSOLE_LOGGER:
				tipoLogger = new ConsoleLogger(new DefaultConfiguration());
				break;
			case BD_LOGGER:
				tipoLogger = new DBLogger(new DefaultConfiguration());
				break;
			default:
				throw new LoggerTypeException("Invalid configuration | Logger type not valid!");
		}
		return tipoLogger;
	}
	
	public static LoggerType getLogger(String type, LoggerConfig configuration) {
		LoggerType tipoLogger = null;

		switch (type) {
			case FILE_LOGGER:
				tipoLogger = new FileLogger(configuration);
				break;
			case CONSOLE_LOGGER:
				tipoLogger = new ConsoleLogger(configuration);
				break;
			case BD_LOGGER:
				tipoLogger = new DBLogger(configuration);
				break;
			default:
			throw new LoggerTypeException("Logger type not valid!");
		}
		return tipoLogger;
	}
}