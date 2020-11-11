package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.mapper.BebidaMapper;
import com.elciocestari.gerenciadorbebidas.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    private BebidaRepository bebidaRepository;

    private final BebidaMapper bebidaMapper = BebidaMapper.INSTANCE;

    @Autowired
    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public Bebida create(BebidaDTO bebidaDTO) {
        Bebida bebidaParaSalvar = bebidaMapper.toModel(bebidaDTO);

        Bebida bebidaSalva = bebidaRepository.save(bebidaParaSalvar);

        return bebidaSalva;
    }

    public List<Bebida> getAll() {
        return bebidaRepository.findAll();
    }

    public Bebida update(long id, BebidaDTO bebidaDTO) {
        return bebidaRepository.findById(id)
                .map(bebida -> {
                    bebida = bebidaMapper.toModel(bebidaDTO);
                    bebida.setId(id);
                    return bebidaRepository.save(bebida);
                }).orElse(null);
    }

    public boolean delete(long id) {
        return bebidaRepository.findById(id)
                .map(bebida -> {
                    bebidaRepository.deleteById(id);
                    return true;
                }).orElse( false );
    }
}
