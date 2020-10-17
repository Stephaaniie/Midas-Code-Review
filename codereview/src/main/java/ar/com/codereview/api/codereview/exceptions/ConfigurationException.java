package ar.com.codereview.api.codereview.exceptions;

/*
    * Exception para cuando sucede algun imprevisto en la
    configuracion y es capturado, el warning que figura es por la falta de un id unico 
    pero no es necesario ponerlo ya que es un error propio del lenguaje. 

*/

public class ConfigurationException extends Exception {
    public ConfigurationException(String message) {
        super(message);
    }
}
