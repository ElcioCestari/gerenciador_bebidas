package com.elciocestari.gerenciadorbebidas.service;


import com.elciocestari.gerenciadorbebidas.dto.UsuarioDTO;
import com.elciocestari.gerenciadorbebidas.entity.Usuario;
import com.elciocestari.gerenciadorbebidas.mapper.UsuarioMapper;
import com.elciocestari.gerenciadorbebidas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(UsuarioDTO usuarioDTO, long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario = usuarioMapper.toModel(usuarioDTO);
                    usuario.setId(id);
                    return usuarioRepository.save(usuario);
                }).orElse(null);

    }

    public Boolean delete(long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
