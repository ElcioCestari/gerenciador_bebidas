package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/bebida")
@RestController
public class BebidaController {

    private BebidaRepository bebidaRepository;

    @Autowired
    public BebidaController(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Bebida bebida) {
        Bebida bebidaSaved = bebidaRepository.save(bebida);

        return MessageResponseDTO.builder()
                .message("Bebida adicionada ao estoque com id " + bebidaSaved.getId())
                .build();
    }

}
