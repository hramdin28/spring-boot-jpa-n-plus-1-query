package com.programmer.answers.advanced.exceptions;

import com.programmer.answers.advanced.exceptions.model.ErrorMessage;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Vous devez ajouter l'annotation @RestControllerAdvice et definir un @ExceptionHandler
 */
//@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage resourceNotFoundException(Exception ex) {
        return new ErrorMessage(
              HttpStatus.INTERNAL_SERVER_ERROR.value(),
              Instant.now(),
              HttpStatus.INTERNAL_SERVER_ERROR.name(),
              ex.getLocalizedMessage());

    }
}
