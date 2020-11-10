package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.mapper.BebidaMapper;
import com.elciocestari.gerenciadorbebidas.mapper.SecaoMapper;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/v1/secao")
@RestController
public class SecaoController {

    private SecaoRepository secaoRepository;

    private final SecaoMapper secaoMapper = SecaoMapper.INSTANCE;

    @Autowired
    public SecaoController(SecaoRepository secaoRepository) {
        this.secaoRepository = secaoRepository;
    }

    @PostMapping
    public MessageResponseDTO save(@RequestBody @Valid SecaoDTO secaoDTO) {

        Secao secaoToSave = secaoMapper.toModel(secaoDTO);
        Secao secaoSalva = secaoRepository.save(secaoToSave);

        return MessageResponseDTO.builder()
                .message("Secao salva com os dados " + secaoSalva.toString())
                .build();
    }

    @GetMapping
    public MessageResponseDTO get() {

        return MessageResponseDTO.builder().message("testando").build();
    }
}
