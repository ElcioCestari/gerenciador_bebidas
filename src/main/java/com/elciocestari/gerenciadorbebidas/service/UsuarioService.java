package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.UsuarioDTO;
import com.elciocestari.gerenciadorbebidas.entity.Usuario;
import com.elciocestari.gerenciadorbebidas.mapper.UsuarioMapper;
import com.elciocestari.gerenciadorbebidas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Faz o intermedio entre o controller e as classes de modelo.
 */
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * cria um Usuario no banco
     * @param usuarioDTO - UsuarioDTO contendos os dados da criação
     * @return Usuario - criado no banco
     */
    public Usuario create(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    /**
     * Busca por todos os Usuario
     * @return List - contendo todos os Usuario
     */
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Atualiza um Usuario
     * @param usuarioDTO  - contem os dados para a atualização
     * @param id - id representando o Usuario a ser atualizado
     * @return Usuario - que foi atuailizado ou null caso nao tenha sido
     */
    public Usuario update(UsuarioDTO usuarioDTO, long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario = usuarioMapper.toModel(usuarioDTO);
                    usuario.setId(id);
                    return usuarioRepository.save(usuario);
                }).orElse(null);

    }

    /**
     * Deleta um Usuario
     * @param id - id do Usuario que sera deletado
     * @return Boolean - true se foi deletado e false caso contrario.
     */
    public Boolean delete(long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
