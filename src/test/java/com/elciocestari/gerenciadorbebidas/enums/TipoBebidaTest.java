package com.elciocestari.gerenciadorbebidas.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipoBebidaTest {

    @Test
    public void testValorTipoBebida(){
        Assertions.assertEquals("ALCOOLICA", TipoBebida.ALCOOLICA.toString());
    }
}
