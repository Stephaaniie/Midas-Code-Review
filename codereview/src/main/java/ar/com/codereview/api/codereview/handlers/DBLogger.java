package ar.com.codereview.api.codereview.handlers;

import java.text.DateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import ar.com.codereview.api.codereview.config.LoggerConfig;
import ar.com.codereview.api.codereview.enums.MessageType;
import ar.com.codereview.api.codereview.exceptions.MessageException;
import ar.com.codereview.api.codereview.interfaces.LoggerType;
import ar.com.codereview.api.codereview.resources.BDManager;

public class DBLogger implements LoggerType {
	
	private BDManager manager;
	
	public DBLogger(LoggerConfig configuration) {
		this.manager = BDManager.getInstance(configuration);
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		String errorMessage = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.MESSAGE.getId());
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
		}
		String errorMessage = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.WARNING.getId());
	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}
		String errorMessage = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.ERROR.getId());
	}
}