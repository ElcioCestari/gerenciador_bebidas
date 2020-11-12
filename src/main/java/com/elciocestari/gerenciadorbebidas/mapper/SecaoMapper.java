package com.elciocestari.gerenciadorbebidas.mapper;

import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Faz o mapeamennto de uma Entity para um DTO e vice-versa.
 */
@Mapper
public interface SecaoMapper {

    SecaoMapper INSTANCE = Mappers.getMapper(SecaoMapper.class);

    Secao toModel(SecaoDTO secaoDTO);

    SecaoDTO toDto(Secao secao);
}
