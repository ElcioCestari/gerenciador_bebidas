package com.elciocestari.gerenciadorbebidas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Quando lançada ira emitir um HttpStatus.BAD_REQUEST
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BebidasDiferentesException extends Exception {

    public static final String MESSAGE = "Bebidas tem que ter o mesmo tipo ";

    public BebidasDiferentesException() {
        super(MESSAGE);
    }

    public BebidasDiferentesException(String message) {
        super(MESSAGE + message);
    }

    public BebidasDiferentesException(String atual, String diferente) {
        super(MESSAGE + " tipo de bebida atual: " + atual + " tipo de bebida diferente: " + diferente ) ;
    }


}
