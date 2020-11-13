package com.elciocestari.gerenciadorbebidas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Quando lançada ira emitir um HttpStatus.BAD_REQUEST
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VolumeMaximoDeBebidaAlcoolicaException extends Throwable {

    private static final String MESSAGE = "foi atingido o numero maximo de Secoes";

    public VolumeMaximoDeBebidaAlcoolicaException() {
        super(MESSAGE);
    }

    public VolumeMaximoDeBebidaAlcoolicaException(String message) {
        super(message);
    }
}
