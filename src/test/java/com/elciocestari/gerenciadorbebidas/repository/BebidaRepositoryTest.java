package com.elciocestari.gerenciadorbebidas.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BebidaRepositoryTest {

    @Mock
    private BebidaRepository bebidaRepository;

    @Test
    public void testsumVolumeFromBebidas(){
        System.out.println(bebidaRepository.sumVolumeFromBebidas());

        Assertions.assertTrue(true);
    }
}
