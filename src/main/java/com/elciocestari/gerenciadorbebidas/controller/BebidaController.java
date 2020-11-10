package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Bebida create(@RequestBody @Valid BebidaDTO bebidaDTO) {
        return bebidaService.create(bebidaDTO);
    }

    @GetMapping
    public List<Bebida> getAll(){
        return bebidaService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid BebidaDTO bebidaDTO){
        return bebidaService.update(id, bebidaDTO );
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO delete(@PathVariable("id") long id){
        return bebidaService.delete(id);
    }
}
