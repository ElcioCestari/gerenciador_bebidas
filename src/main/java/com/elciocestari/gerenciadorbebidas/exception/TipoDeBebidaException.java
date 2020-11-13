package com.elciocestari.gerenciadorbebidas.exception;


import com.elciocestari.gerenciadorbebidas.enums.TipoBebida;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Quando lançada ira emitir um HttpStatus.BAD_REQUEST
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TipoDeBebidaException extends Exception {

    public static final String MESSAGE = "Tipo de bebida invalido. Tipos validos: "
            + TipoBebida.ALCOOLICA.toString() + " "
            + TipoBebida.NAO_ALCOOLICA.toString();

    public TipoDeBebidaException(String message) {
        super(MESSAGE + message);
    }

    public TipoDeBebidaException() {
        super(MESSAGE);
    }
}
