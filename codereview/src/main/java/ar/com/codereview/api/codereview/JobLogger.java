package ar.com.codereview.api.codereview;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.com.codereview.api.codereview.exceptions.ConfigurationException;
import ar.com.codereview.api.codereview.exceptions.NotFoundHandlerException;
import ar.com.codereview.api.codereview.handlers.DBLogger;
import ar.com.codereview.api.codereview.handlers.FileLogger;

/*

El código se utiliza para registrar diferentes mensajes en una aplicación. 
Queremos la capacidad de poder iniciar sesión en un archivo de texto, la consola 
y / o la base de datos. Los mensajes se pueden marcar como mensaje, advertencia o error. 
También queremos la capacidad de poder elegir selectivamente lo que se registra, 
por ejemplo, poder registrar solo errores o solo errores y advertencias.

*/

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

	public static void LogMessage(String messageText, boolean message, boolean warning, boolean error)
			throws NotFoundHandlerException, ConfigurationException, SecurityException, IOException, SQLException {

		if (messageText == null || messageText.length() == 0) {
			return;
		}

		messageText.trim();

		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new NotFoundHandlerException("Invalid configuration");
		}
		if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
			throw new ConfigurationException("Error or Warning or Message must be specified");
		}

		int t = 0;
		if (message && logMessage) {
			t = 1;
		}

		if (error && logError) {
			t = 2;
		}

		if (warning && logWarning) {
			t = 3;
		}

		String l = null;
		
		if (error && logError) {
			l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}

		if (warning && logWarning) {
			l = l + "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}

		if (message && logMessage) {
			l = l + "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}
		
		if(logToFile) {
			logger.addHandler(FileLogger.getFileHandler(dbParams));
			logger.log(Level.INFO, messageText);
		}
		
		if(logToConsole) {
			logger.addHandler(FileLogger.getFileHandler(dbParams));
			logger.log(Level.INFO, messageText);
		}
		
		if(logToDatabase) {
			DBLogger.executeUpdate(dbParams, "insert into Log_Values('" + message + "', " + String.valueOf(t) + ")");
		}
	}
}
