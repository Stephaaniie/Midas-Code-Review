package ar.com.codereview.api.codereview.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.codereview.api.codereview.config.LoggerConfig;

/**
 * Hace la simulacion de la conexion con la BD.
 */

public class BDManager {

    private static BDManager instance = null;

	private LoggerConfig configuration;
	
	private BDManager(LoggerConfig configuration) {
		this.configuration = configuration;
	}
	
	public static synchronized BDManager getInstance(LoggerConfig configuration) {
		if (instance == null) {
			instance = new BDManager(configuration);
		}
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(configuration.getProperty("logger.bd.jdbcDriver"));
			String userName = configuration.getProperty("logger.bd.userName");
			String password = configuration.getProperty("logger.bd.password");
			connection = DriverManager.getConnection(configuration.getProperty("logger.bd.dbUrl"), userName, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("Connection DB error.", e);
		}
		return connection;
	}
	
	public Statement getStatment(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException("Get Statment Connection error.", e);
		}
	}
	
	public void createLogTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.executeUpdate("create table IF NOT EXISTS Log_Values(message varchar(255), type int)");
		} catch (SQLException e) {
			throw new RuntimeException("Create log table BD error.", e);
		} finally {
		}
	}

	public void insertMessageBD(String message, int messageType) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.execute("INSERT INTO Log_Values(message, type) VALUES('" + message + "', " + String.valueOf(messageType) + ")");
		} catch (SQLException e) {
			throw new RuntimeException("Insert message BD error.", e);
		} finally {
		}
	}
	
}