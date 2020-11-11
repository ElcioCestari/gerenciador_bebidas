package com.elciocestari.gerenciadorbebidas.controller;

import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.dto.UsuarioDTO;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.entity.Usuario;
import com.elciocestari.gerenciadorbebidas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/usuarios")
@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Usuario> usuarios =  usuarioService.getAll();

        return  usuarios.size() > 0 ?
                ResponseEntity.ok(usuarios):
                ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid UsuarioDTO usuarioDTO){
        Usuario usuarioSaved = usuarioService.create(usuarioDTO);

        return usuarioSaved != null ?
                ResponseEntity.ok(usuarioSaved):
                ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody @Valid UsuarioDTO usuarioDTO, @PathVariable long id) {
        Usuario usuarioUpdated = usuarioService.update(usuarioDTO, id);

        return usuarioUpdated != null ?
                ResponseEntity.ok(usuarioUpdated) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity delete(@PathVariable long id){
        return  usuarioService.delete(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.noContent().build();
    }
}
