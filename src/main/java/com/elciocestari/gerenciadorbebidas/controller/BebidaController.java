package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public ResponseEntity create(@RequestBody @Valid BebidaDTO bebidaDTO) {
         Bebida bebidaCriada = bebidaService.create(bebidaDTO);

         return ResponseEntity.ok(bebidaCriada);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List list = bebidaService.getAll();

        return list.size() > 0 ?
                ResponseEntity.ok(list) :
                ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid BebidaDTO bebidaDTO) {
        Bebida bebida = bebidaService.update(id, bebidaDTO);

        if (bebida != null) return ResponseEntity.ok(bebida);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        return bebidaService.delete(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
