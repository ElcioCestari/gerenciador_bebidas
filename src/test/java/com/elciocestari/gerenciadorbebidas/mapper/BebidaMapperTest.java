package com.elciocestari.gerenciadorbebidas.mapper;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;


public class BebidaMapperTest {

    private BebidaMapper bebidaMapper;
    private Bebida bebida;

    @BeforeEach
    public void setup() {
        bebidaMapper = BebidaMapper.INSTANCE;

        bebida = Bebida.builder()
                .nome("skoll")
                .build();
    }

    @Test
    public void testConversaoDeBebidaParaBebidaDTO() {

        BebidaDTO dto = bebidaMapper.toDTO(bebida);

        Assert.notNull(dto, dto.getNome());
    }


}
