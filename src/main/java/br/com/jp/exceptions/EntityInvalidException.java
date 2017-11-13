package br.com.jp.exceptions;

/**
 * @author JP on 10/10/17.
 */
public final class EntityInvalidException extends RuntimeException {

    public EntityInvalidException(String message) {
        super(message);
    }

    public EntityInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
