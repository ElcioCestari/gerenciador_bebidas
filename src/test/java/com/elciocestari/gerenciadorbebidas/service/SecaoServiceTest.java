package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class SecaoServiceTest {

    private SecaoDTO secaoDTO;
    private BebidaDTO bebidaDTO;
    private SecaoService secaoService;

    @BeforeEach
    public void setup(){

        bebidaDTO = BebidaDTO.builder()
                .nome("skoll")
                .preco(2.00)
                .volume(200.00)
                .build();

        List<BebidaDTO> dtoList = new ArrayList<>();
        dtoList.add(bebidaDTO);

        secaoDTO = SecaoDTO.builder()
                .bebida(dtoList)
                .nome("Secao A")
                .build();
    }

    @Test
    public void testUpdate(){
        long id = 1;
        secaoService.update(secaoDTO, id);
    }
}
