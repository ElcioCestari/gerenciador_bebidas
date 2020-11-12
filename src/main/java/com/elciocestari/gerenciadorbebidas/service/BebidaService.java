package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.mapper.BebidaMapper;
import com.elciocestari.gerenciadorbebidas.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

@Service

/**
 * Responsável por fazer a comunicação entre o controle e as classes de model.
 */
public class BebidaService {

    private BebidaRepository bebidaRepository;

    private final BebidaMapper bebidaMapper = BebidaMapper.INSTANCE;

    @Autowired
    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    //TODO VER O QUE ACONTECE QUANDO CRIA UMA BEBIDA INVALIDA
    public Bebida create(BebidaDTO bebidaDTO) {
        Bebida bebidaParaSalvar = bebidaMapper.toModel(bebidaDTO);

        Bebida bebidaSalva = bebidaRepository.save(bebidaParaSalvar);

        return bebidaSalva;
    }

    /**
     *
     * @return List<Bebida> contentdo todas bebidas.
     */
    public List<Bebida> getAll() {
        return bebidaRepository.findAll();
    }


    /**
     *
     * @param id - id da Bebida
     * @param bebidaDTO - BebidaDTO contendo os dados para serem atualizados
     * @return - Bebida com os Dados atualizados ou null caso nao sejam atualizados
     */
    public Bebida update(long id, BebidaDTO bebidaDTO) {
        return bebidaRepository.findById(id)
                .map(bebida -> {
                    bebida = bebidaMapper.toModel(bebidaDTO);
                    bebida.setId(id);
                    return bebidaRepository.save(bebida);
                }).orElse(null);
    }

    /**
     * delete uma Bebida
     * @param id - id representa uma Bebida
     * @return - true se a bebida foi delatada e false caso contrario
     */
    public boolean delete(long id) {
        return bebidaRepository.findById(id)
                .map(bebida -> {
                    bebidaRepository.deleteById(id);
                    return true;
                }).orElse( false );
    }


    /**
     * soma o volume de todas as bebidas no banco
     * @return - Double
     */

    public Double getVolumeDeBebidas() {
        Double volume = this.getAll()
                .stream()
                .map(bebida -> bebida.getVolume())
                .reduce(0.0, (atual, prox) -> atual + prox);

        return volume;
    }
}
