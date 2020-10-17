package ar.com.codereview.api.codereview.handlers;

import java.util.logging.ConsoleHandler;

public class ConsoleLogger {
    public static ConsoleHandler getConsoleHandler(){
        return new ConsoleHandler();
    }
}
