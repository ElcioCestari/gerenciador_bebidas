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
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity save(@RequestBody @Valid SecaoDTO secaoDTO) {
        Secao secaoSalva = secaoService.create(secaoDTO);

        return ResponseEntity.ok(secaoSalva);
    }

    @GetMapping
    public ResponseEntity get() {
        List<Secao> list = secaoService.getAll();
        return list.size() > 0 ?
                ResponseEntity.ok(list) :
                ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody @Valid SecaoDTO secaoDTO, @PathVariable long id) {
        Secao secaoUdpated = secaoService.update(secaoDTO, id);

        return secaoUdpated != null ?
                ResponseEntity.ok(secaoUdpated) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return secaoService.delete(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
