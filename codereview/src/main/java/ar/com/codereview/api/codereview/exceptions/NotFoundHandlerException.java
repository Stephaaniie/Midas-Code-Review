package ar.com.codereview.api.codereview.exceptions;

/*
    * Exception para cuando el handler no se encuentra y
    es capturado, el warning que figura es por la falta de un id unico 
    pero no es necesario ponerlo ya que es un error propio del lenguaje. 

*/

public class NotFoundHandlerException extends RuntimeException {
    public NotFoundHandlerException(String message, Exception e) {
        super(message);
    }

}
