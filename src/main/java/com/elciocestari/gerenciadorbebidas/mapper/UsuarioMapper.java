package com.elciocestari.gerenciadorbebidas.mapper;

import com.elciocestari.gerenciadorbebidas.dto.UsuarioDTO;
import com.elciocestari.gerenciadorbebidas.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Faz o mapeamennto de uma Entity para um DTO e vice-versa.
 */
@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toModel(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);
}
