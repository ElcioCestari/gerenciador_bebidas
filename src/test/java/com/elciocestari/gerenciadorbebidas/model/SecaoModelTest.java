package com.elciocestari.gerenciadorbebidas.model;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.enums.TipoBebida;
import com.elciocestari.gerenciadorbebidas.exception.BebidasDiferentesException;
import com.elciocestari.gerenciadorbebidas.exception.TipoDeBebidaException;
import com.elciocestari.gerenciadorbebidas.mapper.BebidaMapper;
import com.elciocestari.gerenciadorbebidas.util.faker.BebidaFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SecaoModelTest  {

    private BebidaDTO bebida;
    private List<Bebida> list = new ArrayList<>();
    private BebidaMapper bebidaMapper = BebidaMapper.INSTANCE;
    private Secao secao;

    @BeforeEach
    public void setup(){
        bebida = new BebidaFake();
        list.add(bebidaMapper.toModel(bebida));
        bebida = new BebidaFake();
        list.add(bebidaMapper.toModel(bebida));
        bebida = new BebidaFake();
        list.add(bebidaMapper.toModel(bebida));
        bebida = new BebidaFake();
        list.add(bebidaMapper.toModel(bebida));

        this.secao = Secao.builder()
                .bebida(list)
                .build();
    }

    @Test
    public void testVerificaBebidaDoMesmoTipo(){
        SecaoModel secaoModel = new SecaoModel();

        try {
            secaoModel.verificaSeBebidasSaoDoMesmoTipo(secao);
        } catch (BebidasDiferentesException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testVerificaBebidaDoMesmoTipo_ComBebidasDiferentes(){
        SecaoModel secaoModel = new SecaoModel();

        bebida.setTipo("tipo errado");
        list.add(bebidaMapper.toModel(bebida));

        try {
            secaoModel.verificaSeBebidasSaoDoMesmoTipo(secao);
        } catch (IllegalArgumentException | BebidasDiferentesException e) {
            Assertions.assertTrue( BebidasDiferentesException.MESSAGE.toString().equals(e.getMessage().toString())  );
        }
    }

    @Test
    public void testVerificaSeTipoDeBebidaEhValido_comBebidasDiferentes(){

        SecaoModel secaoModel = new SecaoModel();
        BebidaDTO dto =  BebidaFake.builder()
                .nome("FANTA")
                .tipo(TipoBebida.NAO_ALCOOLICA.toString())
                .build();

        list.add(bebidaMapper.toModel(dto));

        try {
            secaoModel.verificaSeTipoDeBebidaEhValido(secao);
        } catch ( TipoDeBebidaException e) {
            Assertions.assertTrue( BebidasDiferentesException.MESSAGE.toString().equals(e.getMessage().toString())  );
        }
    }
}
