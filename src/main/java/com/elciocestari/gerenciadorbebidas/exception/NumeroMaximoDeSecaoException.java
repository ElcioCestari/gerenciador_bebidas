package com.elciocestari.gerenciadorbebidas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumeroMaximoDeSecaoException extends Exception{

    private static final String MESSAGE = "foi atingido o numero maximo de Secoes";

    public NumeroMaximoDeSecaoException() {
        super(MESSAGE);
    }

    public NumeroMaximoDeSecaoException(String message) {
        super(message);
    }
}
