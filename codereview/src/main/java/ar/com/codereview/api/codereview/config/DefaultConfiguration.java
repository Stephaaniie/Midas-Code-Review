package ar.com.codereview.api.codereview.config;

public class DefaultConfiguration extends LoggerConfig {

	public static final String LOG_FILE_PATH  = "logger.logFilePath";

    public static final String MESSAGE_LOG_FILE_PATH  = "./data/logFile.txt";
    
    public static final String LOG_BD_USER = "logger.bd.userName";

    public static final String MESSAGE_LOG_BD_USER = "admin";

    public static final String LOG_BD_PASSWORD = "logger.bd.password";
    
    public static final String LOG_BD_DRIVE = "logger.bd.jdbcDriver";
    
    public static final String MESSAGE_LOG_BD_DRIVE = "org.h2.Driver";
    
    public static final String LOG_BD_URL = "logger.bd.dbUrl";
    
    public static final String MESSAGE_LOG_BD_URL = "jdbc:h2:./data/belatrixDB";

    /**
     * crea por default segun el string que recibe por property, lo evalua y
     * devuelve el mensaje correspondiente se utilizo contantes para que el codigo
     * se mantenible a lo largo del tiempo.
     */
    @Override
	public String getProperty(final String property) {
        String message = null;
        
        switch (property) {
            case LOG_FILE_PATH:
                message = MESSAGE_LOG_FILE_PATH;
                break;
            case LOG_BD_USER:
            case LOG_BD_PASSWORD:
                message = MESSAGE_LOG_BD_USER;
                break;
            case LOG_BD_DRIVE:
                message = MESSAGE_LOG_BD_DRIVE;
                break;
            case LOG_BD_URL:
                message = MESSAGE_LOG_BD_URL;
                break;
        }	
		return message;
	}
}