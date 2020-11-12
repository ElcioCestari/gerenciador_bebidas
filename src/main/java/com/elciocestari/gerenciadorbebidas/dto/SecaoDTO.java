package com.elciocestari.gerenciadorbebidas.dto;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecaoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Valid
    private List<BebidaDTO> bebida;

}
