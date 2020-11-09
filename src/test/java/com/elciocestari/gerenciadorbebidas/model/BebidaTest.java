package com.elciocestari.gerenciadorbebidas.model;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.BebidaAlcoolica;
import com.elciocestari.gerenciadorbebidas.entity.BebidaNaoAlcoolica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BebidaTest {

    @Test
    public void testNotNull(){

        Bebida bebida = BebidaAlcoolica.builder()
                .id(Long.valueOf(2))
                .volume(100.00)
                .preco(200.00)
                .nome("wiski")
                .build();


        BebidaAlcoolica bebidaTemp = (BebidaAlcoolica) bebida;

        System.out.println(bebidaTemp);

        Assertions.assertTrue(bebida instanceof Bebida);

    }
}
