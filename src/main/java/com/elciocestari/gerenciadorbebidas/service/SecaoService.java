package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.mapper.SecaoMapper;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecaoService {

    private SecaoRepository secaoRepository;
    private SecaoMapper secaoMapper = SecaoMapper.INSTANCE;

    @Autowired
    public SecaoService(SecaoRepository secaoRepository) {
        this.secaoRepository = secaoRepository;
    }

    public MessageResponseDTO create(SecaoDTO secaoDTO){

        Secao secaoToSave = secaoMapper.toModel(secaoDTO);
        Secao secaoSalva = secaoRepository.save(secaoToSave);

        return MessageResponseDTO.builder()
                .message(secaoSalva.toString())
                .build();
    }
}
