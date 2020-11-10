package com.elciocestari.gerenciadorbebidas.model;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.BebidaAlcoolica;
import com.elciocestari.gerenciadorbebidas.entity.BebidaNaoAlcoolica;
import com.elciocestari.gerenciadorbebidas.repository.BebidaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BebidaTest {

    private BebidaRepository bebidaRepository;

    @Autowired
    public BebidaTest(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    @Test
    public void testBebidaSalva() {

        Bebida bebida = Bebida.builder()
                .volume(100.00)
                .preco(200.00)
                .nome("wiski")
                .build();

        Bebida bebidaSalva = bebidaRepository.save(bebida);

        Assertions.assertNotNull(bebidaSalva);

    }
}
