package ar.com.codereview.api.codereview.config;

import java.io.Serializable;

/**
 * implementa Serializable que es una herramienta propia de JAVA que lo que
 * recibe es un string que va a ser evaluado segun el tipo de logeo donde sea
 * llamado.
 */
public abstract class LoggerConfig implements Serializable{
    
    public abstract String getProperty(final String property);
}
