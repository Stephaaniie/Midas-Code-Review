package ar.com.codereview.api.codereview.config;

import java.io.Serializable;

public abstract class LoggerConfig implements Serializable{
    
    public abstract String getProperty(final String property);
}
