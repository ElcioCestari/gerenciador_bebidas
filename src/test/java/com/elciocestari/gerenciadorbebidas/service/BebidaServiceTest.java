package com.elciocestari.gerenciadorbebidas.service;


import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.repository.BebidaRepository;
import com.elciocestari.gerenciadorbebidas.util.faker.BebidaFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BebidaServiceTest {

    @Mock
    private BebidaRepository bebidaRepository;

    @InjectMocks
    private BebidaService bebidaService;

    @BeforeEach
    public void addBebida(){
        BebidaDTO bebidaFake = new BebidaFake();

        Bebida bebida = this.bebidaService.create(bebidaFake);

        Assertions.assertNotNull(bebida);
    }

    @Test
    public void testSelectAll(){
        List<Bebida> list = this.bebidaService.getAll();

        Assertions.assertTrue(list.size() > 0);
    }
}
