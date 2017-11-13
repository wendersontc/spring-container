package br.com.jp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JP on 10/10/17
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        Map<String, Object> response = getResponse(errors, HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityInvalidException.class)
    public ResponseEntity<Map<String, Object>> entityInvalidExceptionHandler(Exception e) {

        Map<String, Object> response = getResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> entityNotFoundExceptionHandler(EntityNotFoundException e) {

        Map<String, Object> response = getResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> entityConstraintViolationExceptionHandler(EntityConstraintViolationException e) {

        Map<String, Object> response = getResponse(e.getMessage(), HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

//    private Map<String, Object> getResponse(Object obj, String msg, Integer errorCode) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("errors", msg);
//        response.put("errorCode", errorCode);
//
//        return response;
//    }

    private Map<String, Object> getResponse(Object msg, Integer errorCode) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", msg);
        response.put("errorCode", errorCode);

        return response;
    }
}

