package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.CustomResponseDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.exception.BebidasDiferentesException;
import com.elciocestari.gerenciadorbebidas.exception.NumeroMaximoDeSecaoException;
import com.elciocestari.gerenciadorbebidas.exception.TipoDeBebidaException;
import com.elciocestari.gerenciadorbebidas.exception.VolumeMaximoDeBebidaAlcoolicaException;
import com.elciocestari.gerenciadorbebidas.mapper.SecaoMapper;
import com.elciocestari.gerenciadorbebidas.model.SecaoModel;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Faz o intermedio entre o controller e as classes de model
 */
@Service
public class SecaoService {

    private SecaoRepository secaoRepository;
    private SecaoMapper secaoMapper = SecaoMapper.INSTANCE;
    private SecaoModel secaoModel;

    @Autowired
    public SecaoService(SecaoRepository secaoRepository, SecaoModel secaoModel) {
        this.secaoRepository = secaoRepository;
        this.secaoModel = secaoModel;
    }

    /**
     * Cria uma Secao no banco
     *
     * @param secaoDTO - SecaoDTO com os dados que serão salvos para a criação de uma nova Secao
     * @return - Secao criada no banco
     * @throws NumeroMaximoDeSecaoException           - caso tenha atingido o numero maxio de seções permitidas de acordo com a regra
     * @throws VolumeMaximoDeBebidaAlcoolicaException - caso a secao tnha atingido o volume maximo de bebidas
     */
    public Secao create(SecaoDTO secaoDTO)
            throws NumeroMaximoDeSecaoException, VolumeMaximoDeBebidaAlcoolicaException,
            BebidasDiferentesException, IllegalArgumentException, TipoDeBebidaException {

        this.secaoModel.numeroMaximoDeSecao(this.getAll());
        this.secaoModel.volumeMaximoDeBebidaAlcoolica(this.getVolumeBySecao(secaoDTO));
        this.secaoModel.verificaSeBebidasSaoDoMesmoTipo(secaoMapper.toModel(secaoDTO));
        this.secaoModel.verificaSeTipoDeBebidaEhValido(secaoMapper.toModel(secaoDTO));
        Secao secaoToSave = secaoMapper.toModel(secaoDTO);
        return secaoRepository.save(secaoToSave);
    }

    /**
     * Recupera todas as Secao no banco
     *
     * @return - List com todas as Secao
     */
    public List<Secao> getAll() {
        return secaoRepository.findAll();
    }

    /**
     * Atualiza uma Secao
     *
     * @param secaoDTO - SecaoDTO contem os dados para serem atualizados
     * @param id       - id que representa a seção que sera atualizada
     * @return - Secao com os dados atualizados ou null caso nao seja feita a atualização
     */
    public Secao update(SecaoDTO secaoDTO, long id) {
        return secaoRepository.findById(id)
                .map(secao -> {
                    secao = secaoMapper.toModel(secaoDTO);
                    secao.setId(id);
                    return secaoRepository.save(secao);
                }).orElse(null);

    }

    /**
     * delete uma Secao
     *
     * @param id - id da Secao que será deleta
     * @return Boolean - true se foi deletado e false caso contrario.
     */
    public Boolean delete(long id) {
        return secaoRepository.findById(id)
                .map(secao -> {
                    secaoRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }

    /**
     * Retorna o volume total de bebidas da Secao
     *
     * @param id - id representa a Secao que sera pesquisada
     * @return Double - 0.0 caso o volume da Secao seja vazio caso contrario o total
     */
    public Double getVolume(long id) {
        List<Secao> list = this.getAll();
        Double volume = 0.0;

        for (Secao secao : list) {
            if (id == secao.getId())
                for (Bebida bebida : secao.getBebida()) {
                    volume += bebida.getVolume();
                }
        }
        return volume;
    }

    public Double getVolumeBySecao(SecaoDTO secaoDTO) {
        List<BebidaDTO> list = secaoDTO.getBebida();
        Double volume = 0.0;

        for (BebidaDTO bebida : list) {
            volume += bebida.getVolume();
        }
        return volume;
    }

    public List<CustomResponseDTO> test(long id) {
        //return this.secaoRepository.getVolumeById();
        return null;
    }
}
