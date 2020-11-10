package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.mapper.BebidaMapper;
import com.elciocestari.gerenciadorbebidas.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BebidaService {

    private BebidaRepository bebidaRepository;

    private final BebidaMapper bebidaMapper = BebidaMapper.INSTANCE;

    @Autowired
    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public MessageResponseDTO create( BebidaDTO bebidaDTO) {

        Bebida bebidaParaSalvar = bebidaMapper.toModel(bebidaDTO);

        Bebida bebidaSalva = bebidaRepository.save(bebidaParaSalvar);

        return MessageResponseDTO.builder()
                .message("Bebida adicionada ao estoque com id " + bebidaSalva.getId().toString())
                .build();
    }
}
