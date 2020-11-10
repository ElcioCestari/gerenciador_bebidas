package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.mapper.SecaoMapper;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecaoService {

    private SecaoRepository secaoRepository;
    private SecaoMapper secaoMapper = SecaoMapper.INSTANCE;

    @Autowired
    public SecaoService(SecaoRepository secaoRepository) {
        this.secaoRepository = secaoRepository;
    }

    public Secao create(SecaoDTO secaoDTO) {
        Secao secaoToSave = secaoMapper.toModel(secaoDTO);
        return secaoRepository.save(secaoToSave);
    }

    public List<Secao> getAll() {
        return secaoRepository.findAll();
    }

    public Secao update(SecaoDTO secaoDTO, long id) {
        Optional<Secao> secaoOptional = this.getById(id);

        if (!secaoOptional.isPresent()) return null;

        secaoDTO.setId(id);

        return this.create(secaoDTO);
    }

    public Optional<Secao> getById(long id) {
        return secaoRepository.findById(id);
    }

    public MessageResponseDTO delete(long id) {

       Optional<Secao> secaoOptional =  this.getById(id);

       if(!secaoOptional.isPresent()) {
           return MessageResponseDTO.builder()
                   .message("secao nao encontrada com o id: " + id)
                   .build();
       }

        secaoRepository.deleteById(id);
        return MessageResponseDTO.builder()
                .message("secao deletada")
                .build();
    }
}
