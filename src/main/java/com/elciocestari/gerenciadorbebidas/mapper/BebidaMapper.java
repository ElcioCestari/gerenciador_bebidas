package com.elciocestari.gerenciadorbebidas.mapper;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * Faz o mapeamennto de uma Entity para um DTO e vice-versa.
 */
@Mapper
public interface BebidaMapper {

    BebidaMapper INSTANCE = Mappers.getMapper(BebidaMapper.class);

    Bebida toModel(BebidaDTO bebidaDTO);

    BebidaDTO toDTO(Bebida bebida);

}
