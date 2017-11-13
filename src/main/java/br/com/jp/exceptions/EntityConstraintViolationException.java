package br.com.jp.exceptions;

/**
 * @author JP on 10/10/17.
 */
public final class EntityConstraintViolationException extends RuntimeException {

    public EntityConstraintViolationException(String message) {
        super(message);
    }

    public EntityConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
