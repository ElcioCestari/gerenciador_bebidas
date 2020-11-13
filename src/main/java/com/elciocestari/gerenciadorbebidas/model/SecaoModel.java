package com.elciocestari.gerenciadorbebidas.model;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.enums.TipoBebida;
import com.elciocestari.gerenciadorbebidas.exception.BebidasDiferentesException;
import com.elciocestari.gerenciadorbebidas.exception.NumeroMaximoDeSecaoException;
import com.elciocestari.gerenciadorbebidas.exception.TipoDeBebidaException;
import com.elciocestari.gerenciadorbebidas.exception.VolumeMaximoDeBebidaAlcoolicaException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SecaoModel implements Validacao {

    /**
     * representa o numero maximo de seções permitidas de acordo com a regre de negocio
     */
    public static final int NUMERO_MAXIMO_SECAO = 5;
    public static final Double VOLUME_MAXIMO_BEBIDA_ALCOOLICA = 400.00;


    @Override
    public void numeroMaximoDeSecao(List<Secao> list) throws NumeroMaximoDeSecaoException {
        if (list.size() >= NUMERO_MAXIMO_SECAO) {
            throw new NumeroMaximoDeSecaoException();
        }
    }

    @Override
    public void volumeMaximoDeBebidaAlcoolica(Double volume) throws VolumeMaximoDeBebidaAlcoolicaException {
        if (volume > VOLUME_MAXIMO_BEBIDA_ALCOOLICA) {
            throw new VolumeMaximoDeBebidaAlcoolicaException();
        }
    }

    @Override
    public void verificaSeBebidasSaoDoMesmoTipo(Secao secao) throws BebidasDiferentesException, IllegalArgumentException {
        secao.getBebida().stream()
                .map(bebida -> bebida.getTipo())
                .reduce((s, s2) -> compare(s, s2));
    }

    @Override
    public void verificaSeTipoDeBebidaEhValido(Secao secao) throws TipoDeBebidaException {
        String alcoolica = TipoBebida.ALCOOLICA.toString();
        String naoAlcoolica = TipoBebida.NAO_ALCOOLICA.toString();
        for (Bebida bebida: secao.getBebida()) {
            boolean primeira = ! bebida.getTipo().equals(alcoolica);
            boolean segunda = ! bebida.getTipo().equals(naoAlcoolica);
            if( (primeira &&  segunda)  ) {
                throw new TipoDeBebidaException();
            }
        }
    }

    private String compare(String s, String s2) throws IllegalArgumentException {
        if( ! s.toString().equals(s2.toString()) ) throw new  IllegalArgumentException(BebidasDiferentesException.MESSAGE);
        return s;
    }
}
