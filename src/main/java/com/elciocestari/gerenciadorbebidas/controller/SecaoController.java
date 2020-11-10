package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.mapper.BebidaMapper;
import com.elciocestari.gerenciadorbebidas.mapper.SecaoMapper;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import com.elciocestari.gerenciadorbebidas.service.SecaoService;
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

    private SecaoService secaoService;

    @Autowired
    public SecaoController(SecaoService secaoService) {
        this.secaoService = secaoService;
    }

    @PostMapping
    public MessageResponseDTO save(@RequestBody @Valid SecaoDTO secaoDTO) {
        return secaoService.create(secaoDTO);
    }

    @GetMapping
    public List<Secao> get() {
        return secaoService.getAll();
    }
}
