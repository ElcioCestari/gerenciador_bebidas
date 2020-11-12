package com.elciocestari.gerenciadorbebidas.model;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;

public class SecaoTest {

    private Secao secao;
    private SecaoRepository secaoRepository;
    private Bebida bebida;

    @BeforeEach
    public void setup(){
        bebida = Bebida.builder()
                .id(Long.valueOf(1))
                .nome("Fanta")
                .preco(20.02)
                .volume(0.200)
                .tipo("nao_alcoolica")
                .build();

        secao = Secao.builder()
                .nome("A")
//                .bebidas(bebida)
                .build();

    }

    @Test
    public void testInsertSecao(){
        Secao secaoSaved = null;

        try {
            secaoSaved = secaoRepository.save(secaoSaved);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.notNull(secaoSaved, "secao salva");
    }
}
