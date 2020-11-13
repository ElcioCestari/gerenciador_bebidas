package com.elciocestari.gerenciadorbebidas.model;

import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.exception.BebidasDiferentesException;
import com.elciocestari.gerenciadorbebidas.exception.NumeroMaximoDeSecaoException;
import com.elciocestari.gerenciadorbebidas.exception.TipoDeBebidaException;
import com.elciocestari.gerenciadorbebidas.exception.VolumeMaximoDeBebidaAlcoolicaException;
import java.util.List;

public interface Validacao{
    void numeroMaximoDeSecao(List<Secao>  list) throws NumeroMaximoDeSecaoException;

    void volumeMaximoDeBebidaAlcoolica(Double volume) throws VolumeMaximoDeBebidaAlcoolicaException;

    void verificaSeBebidasSaoDoMesmoTipo(Secao secao) throws BebidasDiferentesException;

    void verificaSeTipoDeBebidaEhValido(Secao secao) throws TipoDeBebidaException;

}
