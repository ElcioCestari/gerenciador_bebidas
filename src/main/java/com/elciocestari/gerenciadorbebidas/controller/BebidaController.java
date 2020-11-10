package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/bebida")
@RestController
public class BebidaController {

    private BebidaService bebidaService;

    @Autowired
    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BebidaDTO bebidaDTO) {

        return bebidaService.create(bebidaDTO);
    }

    @GetMapping
    public List<Bebida> getAll(){
        return bebidaService.getAll();
    }

}
